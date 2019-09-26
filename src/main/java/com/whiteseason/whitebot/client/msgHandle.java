package com.whiteseason.whitebot.client;

import com.whiteseason.whitebot.bean.BestMap;
import com.whiteseason.whitebot.bean.User;
import com.whiteseason.whitebot.bean.UserInfo;
import com.whiteseason.whitebot.dao.UserDaoImpl;
import com.whiteseason.whitebot.util.DbUtil;
import com.whiteseason.whitebot.util.osu.OsuInfoGet;
import org.meowy.cqp.jcq.message.CQCode;

import java.sql.Connection;
import java.util.Objects;

public class msgHandle {

    private String msg;
    private Connection conn = DbUtil.openConnection("jdbc:mysql://localhost:3306/whitebot","root","whiteseason");

    static String[] Handle(String msg1) {
        msg1 = new CQCode().decode(msg1).substring(1);
        String[] msg2 = msg1.split(" ", 2);
        return msg2;
    }

    private String showUserInfo(User user){
        return "pp："+ user.getPp_raw()+"\n全球排名："+user.getPp_rank()+"所属地区及排名"+ user.getCountry()+"#"+user.getPp_country_rank()+"\n准确率："+user.getAccuracy();
    }

    public String joinGroup(long qq,long GroupQQ){
        switch (Long.toString(GroupQQ)){
            case "885984366":
                msg = "欢迎[CQ:at,qq="+qq+"]加入osu!新人群，请阅读本群公告了解本群具体规则哦！";
                break;
            case "414752793":
                msg = "欢迎萌萌哒的[CQ:at,qq="+qq+"]加入糕姐的后宫，请阅读本群公告了解本群具体规则哦！";
                break;
            default:
                msg = "欢迎[CQ:at,qq="+qq+"加入本群，请从群公告开始了解本群哦";
        }
        return msg;
    }

    public String InserUser(String name ,long qq){
        Objects.requireNonNull(name);
        Objects.requireNonNull(qq);
        String string = "";
        Connection connection = conn;

        UserInfo ui = OsuInfoGet.getUser(name,0);
        if(ui == null){
            string += "查询用户失败，请检查用户名是否正确（或者ppy傻逼网络又炸了)";
            return string;
        }else if(new UserDaoImpl(connection).getUser(qq) != null){
            return "此QQ用户已绑定，绑定玩家为："+new UserDaoImpl(connection).getUser(qq).getUsername()+",请勿重复绑定";
        }
        User user = new User(qq,ui.getUser_id(),ui.getUsername(),ui.getPp_rank(),ui.getPp_raw(),ui.getAccuracy(),ui.getCountry(),ui.getPp_country_rank(),0.0);
        BestMap[] bp = OsuInfoGet.UserBsetMap(user,0);
        if(bp.length == 0){
            string += "bp获取失败,自动设置bp1为0\n";

        }else {
            user.setBp(Double.parseDouble(bp[0].getPp()));
        }
        if(new UserDaoImpl(connection).insertUser(user)){
            string+="用户添加成功，"+user.getUsername()+"信息如下:\n"+showUserInfo(user);
        }else {
            return "whitebot故障，请联系白季改bug（白季：卧槽咋又出bug了）";
        }
        return string;
    }



}
