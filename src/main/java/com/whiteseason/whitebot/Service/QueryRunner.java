package com.whiteseason.whitebot.Service;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.whiteseason.whitebot.util.DbUtil;


public class QueryRunner {
	private Connection connection;

	public QueryRunner(Connection connection) {
		this.connection = connection;
	}

	//增加，删除，修改
	public int executeUpdate(String sql, Object... objects) {
		Objects.requireNonNull(sql);
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]);
				System.out.println(objects[i].getClass().getName());
			}
			int rows = ps.executeUpdate();
			DbUtil.closeStatement(ps);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	//单个查询（通过Java反射）
	public <T> T executeQuery(String sql, Class<T> bean, Object... objects) {
		Objects.requireNonNull(sql);
		T resultObject = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[0]);
			}
			ResultSet resultSet = ps.executeQuery();
			ResultSetMetaData rsm = resultSet.getMetaData();
			int flag = 1;
			Field[] field = bean.getDeclaredFields();
			Class<?> clazz = bean;
			for (; clazz != Object.class; clazz = clazz.getSuperclass()){
				Field[] i = clazz.getDeclaredFields();
				field = QueryRunner.concat(field,i);
			}

			while(resultSet.next()){
				 resultObject = bean.newInstance();
				for (int i = 0; i < rsm.getColumnCount(); i++) {
					String name = rsm.getColumnName(i+1);
					Object value = resultSet.getObject(name);
//					if(value == null) value = "";
					for (Field f:field) {
						if (name.equals(f.getName())){
							f.setAccessible(true);
							f.set(resultObject,value);
						}
					}
				}
			}
			DbUtil.closeStatement(ps);
			DbUtil.closeResultSet(resultSet);
			return resultObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//多组查询（通过Java反射）
	public <T> List<T> executeQueryList(String sql, Class<T> bean, Object... objects) {
		Objects.requireNonNull(sql);
		List<T> list = new ArrayList<T>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[0]);
			}
			ResultSet resultSet = ps.executeQuery();
			ResultSetMetaData rsm = resultSet.getMetaData();
			while(resultSet.next()){
				T resultObject = bean.newInstance();
				Field[] field = bean.getDeclaredFields();
				Class<?> clazz = bean;
				for (; clazz != Object.class; clazz = clazz.getSuperclass()){
					Field[] i = clazz.getDeclaredFields();
					field = QueryRunner.concat(field,i);
				}
				for (int i = 0; i < rsm.getColumnCount(); i++) {
					String name = rsm.getColumnName(i+1);
					Object value = resultSet.getObject(name);
					if(value == null) {
						switch (name){
							case "qq":
								value = 0L;
								break;
							case "bp":
								value = 0.0;
								break;
							default:
								value = "";
								break;
						}
					}
					for (Field f:field) {
						if (name.equals(f.getName())){
							f.setAccessible(true);
							f.set(resultObject,value);
						}
					}
				}
				list.add(resultObject);
			}
			DbUtil.closeStatement(ps);
			DbUtil.closeResultSet(resultSet);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static <T> T[] concat(T[] first, T[] second) {

		T[] result = Arrays.copyOf(first, first.length + second.length);

		System.arraycopy(second, 0, result, first.length, second.length);

		return result;

	}
}
