package com.whiteseason.whitebot.dao;

import com.whiteseason.whitebot.bean.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    Connection connection = null;

    /**
     * 添加单个玩家
     * @param u
     * @return 是否成功
     */
    boolean insertPublicUser(User u);
    /**
     * 更新玩家数据
     * @param list
     * @return 添加数量
     */
    int updatePublicUser(List<User> list);
    /**
     * 根据QQ查询单个用户
     * @param qq
     * @return 是否成功
     */
    User getPublicUser(long qq);
    /**
     * 获取所有用户
     * @return List
     */
    List<User> getPublicAllUser();
    /**
     * 通过QQ查询删除用户
     * @param qq
     * @return 是否成功
     */
    boolean delectPublicUser(long qq);

    /**
     * 添加单个玩家
     * @param u
     * @return 是否成功
     */
    boolean insertUser(User u);
    /**
     * 更新玩家数据
     * @param list
     * @return 添加数量
     */
    int updateUser(List<User> list);
    /**
     * 根据QQ查询单个用户
     * @param qq
     * @return 是否成功
     */
    User getUser(long qq);
    /**
     * 获取所有用户
     * @return List
     */
    List<User> getAllUser();
    /**
     * 通过QQ查询删除用户
     * @param qq
     * @return 是否成功
     */
    boolean delectUser(long qq);
    /**
     * 关闭连接
     * @return 是否成功
     */
    boolean closeconn();
}
