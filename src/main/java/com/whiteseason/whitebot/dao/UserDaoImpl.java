package com.whiteseason.whitebot.dao;

import com.whiteseason.whitebot.Service.QueryRunner;
import com.whiteseason.whitebot.bean.User;
import com.whiteseason.whitebot.util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection;
    QueryRunner qr;
    public UserDaoImpl(Connection connection) {
        this.connection = connection;
        qr = new QueryRunner(connection);
    }


    @Override
    public boolean insertPublicUser(User u) {
        return qr.executeUpdate("insert into publicuserinfo values(?,?,?,?,?,?,?,?,?)", u.getQq(), u.getUser_id() , u.getUsername() , u.getPp_raw()
                ,u.getPp_rank() , u.getCountry() , u.getPp_country_rank() , u.getAccuracy().substring(0, 5), u.getBp()) > 0;
    }

    @Override
    public int updatePublicUser(List<User> list) {
        String sql ="update publicuserinfo set pp_raw = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_raw();
        }
        sql+=" end,pp_rank = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_rank();
        }
        sql+=" end,pp_country_rank = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_country_rank();
        }
        sql+=" end,accuracy = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getAccuracy();
        }
        sql+=" end,bp = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getBp();
        }
        sql+= " end where qq in (";
        for (int i = 0; i < list.size(); i++) {
            if(list.size() == 1 || i  == list.size() - 1){
                sql+=" " + list.get(i).getQq();
            }else {
                sql+=" " + list.get(i).getQq()+",";
            }
        }
        sql+= " )";
        return qr.executeUpdate(sql);
    }

    @Override
    public User getPublicUser(long qq) {
        return qr.executeQuery("select * from publicuserinfo where qq = " + qq,User.class);
    }

    @Override
    public List<User> getPublicAllUser() {
        return qr.executeQueryList("select * from publicuserinfo",User.class);
    }

    @Override
    public boolean delectPublicUser(long qq) {
        return qr.executeUpdate("delete from publicuserinfo where qq = "+ qq) > 0;
    }

    @Override
    public boolean insertUser(User u) {
        return qr.executeUpdate("insert into userinfo values(?,?,?,?,?,?,?,?,?)", u.getQq(), u.getUser_id() , u.getUsername() , u.getPp_raw()
                ,u.getPp_rank() , u.getCountry() , u.getPp_country_rank() , u.getAccuracy().substring(0, 5), u.getBp()) > 0;
    }

    @Override
    public int updateUser(List<User> list) {
        String sql ="update userinfo set pp_raw = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_raw();
        }
        sql+=" end,pp_rank = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_rank();
        }
        sql+=" end,pp_country_rank = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getPp_country_rank();
        }
        sql+=" end,accuracy = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getAccuracy();
        }
        sql+=" end,bp = case qq";
        for (int i = 0; i < list.size(); i++) {
            sql+= " when " + list.get(i).getQq() + " then " + list.get(i).getBp();
        }
        sql+= " end where qq in (";
        for (int i = 0; i < list.size(); i++) {
            if(list.size() == 1 || i  == list.size() - 1){
                sql+=" " + list.get(i).getQq();
            }else {
                sql+=" " + list.get(i).getQq()+",";
            }
        }
        sql+= " )";
        return qr.executeUpdate(sql);
    }

    @Override
    public User getUser(long qq) {
        return qr.executeQuery("select * from userinfo where qq = " + qq,User.class);
    }

    @Override
    public List<User> getAllUser() {
        return qr.executeQueryList("select * from userinfo",User.class);
    }

    @Override
    public boolean delectUser(long qq) {
        return qr.executeUpdate("delete from userinfo where qq = "+ qq) > 0;
    }

    @Override
    public boolean closeconn() {
        DbUtil.closeConnection(connection);
        return true;
    }
}
