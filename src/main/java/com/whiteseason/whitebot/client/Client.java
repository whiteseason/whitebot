package com.whiteseason.whitebot.client;

import com.whiteseason.whitebot.bean.User;
import com.whiteseason.whitebot.bean.UserInfo;
import com.whiteseason.whitebot.dao.UserDaoImpl;
import com.whiteseason.whitebot.util.DbUtil;
import com.whiteseason.whitebot.util.osu.OsuInfoGet;

import java.text.DecimalFormat;

public class Client {

    private DecimalFormat decimalFormat = new DecimalFormat("####.00");

    public String publicHandle(String msg1,long fromQQ){

        if (msg1.indexOf("!") == 0 || msg1.indexOf("！") == 0) {
            String[] string = msgHandle.Handle(msg1);
            UserInfo userInfo = null;
            User user = null;
            switch (string[0]){
                case "whitebot":
                    return f1();
                case "std":
                    if(string.length == 1 || string[1] == null){
                        return "请输入用户名，例如!std whitebot";
                    }
                    userInfo = OsuInfoGet.getUser(string[1],0);
                    if(userInfo == null){
                        return "获取用户数据异常，请检查输入的用户名是否正确";
                    }else {
                        return "玩家"+userInfo.getUsername()+"在std模式下的游玩数据如下：\n"+
                                "PP："+decimalFormat.format(Double.valueOf(userInfo.getPp_raw()))+
                                "\n世界排名："+userInfo.getPp_rank()
                                +"\n所属地区及排名"+userInfo.getCountry()+" #"+userInfo.getPp_country_rank()
                                +"\nAcc(准确率）："+decimalFormat.format(Double.valueOf(userInfo.getAccuracy()));
                    }
                case "mystd":
                    UserDaoImpl udi = new UserDaoImpl(DbUtil.openConnection("jdbc:mysql://localhost:3306/whitebot","root","whiteseason"));
                    user = udi.getUser(fromQQ);
                    userInfo = OsuInfoGet.getUser(user.getUsername(),0);
                    if(user == null) {
                        udi.closeconn();
                        return "你还没绑定，请使用!help查看绑定指令";
                    }
                    else{
                        udi.closeconn();
                        return "玩家"+userInfo.getUsername()+"在std模式下的游玩数据如下：\n"+
                                "PP："+decimalFormat.format(Double.valueOf(userInfo.getPp_raw()))+"("+decimalFormat.format(Double.valueOf(userInfo.getPp_raw()) - Double.valueOf(user.getPp_raw()))+")"+
                                "\n世界排名："+userInfo.getPp_rank()+"("+decimalFormat.format(Double.valueOf(userInfo.getPp_rank()) - Double.valueOf(user.getPp_rank()))+")"
                                +"\n所属地区及排名"+userInfo.getCountry()+" #"+userInfo.getPp_country_rank()
                                +"\nAcc(准确率）："+decimalFormat.format(Double.valueOf(userInfo.getAccuracy()))+"("+decimalFormat.format(Double.valueOf(userInfo.getAccuracy()) - Double.valueOf(user.getAccuracy()))+")";
                    }
                case "setname":
                    if(string.length == 1 || string[1] == null){
                        return "请输入用户名，例如!setname whitebot";
                    }
                    return new msgHandle().InserUser(string[1],fromQQ);
                default:
                    break;
            }
        }

        return null;
    }

    String f1(){
      return   "whitebot v0.0.4帮助文档\n" +
                "1、!setname <osu!name> 将你的id绑定至whitebot数据库\n" +
                "例如: !setname whtiebot\n" +
                "2、!myrank 查询自己的rank信息（需使用!setname绑定）\n" +
                "3、!std <osuname>查询他人的osu!stdrank信息\n" +
                "例如：!std whitebot";
    }
}
