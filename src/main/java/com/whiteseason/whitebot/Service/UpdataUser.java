package com.whiteseason.whitebot.Service;

import com.whiteseason.whitebot.bean.BestMap;
import com.whiteseason.whitebot.bean.User;
import com.whiteseason.whitebot.bean.UserInfo;
import com.whiteseason.whitebot.dao.UserDaoImpl;
import com.whiteseason.whitebot.util.DbUtil;
import com.whiteseason.whitebot.util.osu.OsuInfoGet;


import java.util.*;

public class UpdataUser {

    public static void main(String[] args) {
        new UpdataUser().updateDb();
    }

    private static List updateDb() {
        // TODO Auto-generated method stub
        UserDaoImpl udi = new UserDaoImpl(DbUtil.openConnection("jdbc:mysql://localhost:3306/whitebot","root","whiteseason"));
        List<User> list = udi.getAllUser();
        List<User> unbindUser = new ArrayList<>();
        List<User> nl = new ArrayList<>();
        List<User> failUser = new ArrayList<>();
        int i = 1;
        UserInfo ui;
        BestMap[] bp;
        for (User u:
                list) {
            if(u.getUser_id() != ""){
                ui = new OsuInfoGet().getUser(u.getUser_id(),0);
                bp = OsuInfoGet.UserBsetMap(u,0);
                if(bp == null || bp.length == 0){
                    failUser.add(u);
                    continue;
                }else if (ui == null){
                    failUser.add(u);
                    continue;
                }
                User nu = new User(u.getQq(),ui.getUser_id(),ui.getUsername(),
                        ui.getPp_rank(),ui.getPp_raw(),ui.getAccuracy(),ui.getCountry(),ui.getPp_country_rank(),Double.parseDouble(bp[0].getPp()));
                if(Double.valueOf(nu.getPp_raw()) >= 2800 || Double.valueOf(nu.getBp()) >= 190){
                    unbindUser.add(nu);
                    nl.add(nu);
                }else {
                    nl.add(nu);
                }
            }else{
                failUser.add(u);
            }
        }
        udi.updateUser(nl);
        udi.closeconn();
        List<List<User>> list1 = new ArrayList();
        list1.add(unbindUser);
        list1.add(failUser);
        list1.add(nl);
        mListener.getList(list1);
        return list1;
    }

    public static boolean controlled() {
        long daySpan = 24 * 60 * 60 * 1000;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateDb();
            }
        }, daySpan, daySpan);
        return true;
    }

    private static OnUpdateListener mListener;
    public static void setListener(OnUpdateListener listener) {
        mListener = listener;
    }
    public interface OnUpdateListener {
        void getList(List<List<User>> list);
    }
}
