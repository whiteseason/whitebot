package com.whiteseason.whitebot.bean;

public class User extends UserInfo {
    private long qq;
    private double bp;

    public User(){
        super();
    }

    public User(long qq,String user_id, String username, String pp_rank,
                String pp_raw, String accuracy, String country, String pp_country_rank,double bp) {
        super(user_id,username,pp_rank,pp_raw,accuracy,country,pp_country_rank);
        this.qq = qq;
        this.bp = bp;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    @Override
    public String toString() {
        return "User{" +
                "qq=" + qq +
                "} " + super.toString();
    }
}
