package com.whiteseason.whitebot.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DbUtil {

	public static void loadDriver(String driverName) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			new RuntimeException("this driver can not loading!");
		}
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection openConnection(String url, String user, String password) {
		
		Objects.requireNonNull(url);
		Objects.requireNonNull(user);
		Objects.requireNonNull(password);
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("can not connection database!");
		}
	}
	
}
