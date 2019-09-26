package com.whiteseason.whitebot.bean;

import java.util.Date;

public class BestMap {
    private String beatmap_id;
    private String score_id;
    private String score;
    private String maxcombo;
    private String count50;
    private String count100;
    private String count300;
    private String countmiss;
    private String countkatu;
    private String countgeki;
    private String perfect;
    private String enabled_mods;
    private String user_id;
    private Date date;
    private String rank;
    private String pp;
    public void setBeatmap_id(String beatmap_id) {
        this.beatmap_id = beatmap_id;
    }
    public String getBeatmap_id() {
        return beatmap_id;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }
    public String getScore_id() {
        return score_id;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getScore() {
        return score;
    }

    public void setMaxcombo(String maxcombo) {
        this.maxcombo = maxcombo;
    }
    public String getMaxcombo() {
        return maxcombo;
    }

    public void setCount50(String count50) {
        this.count50 = count50;
    }
    public String getCount50() {
        return count50;
    }

    public void setCount100(String count100) {
        this.count100 = count100;
    }
    public String getCount100() {
        return count100;
    }

    public void setCount300(String count300) {
        this.count300 = count300;
    }
    public String getCount300() {
        return count300;
    }

    public void setCountmiss(String countmiss) {
        this.countmiss = countmiss;
    }
    public String getCountmiss() {
        return countmiss;
    }

    public void setCountkatu(String countkatu) {
        this.countkatu = countkatu;
    }
    public String getCountkatu() {
        return countkatu;
    }

    public void setCountgeki(String countgeki) {
        this.countgeki = countgeki;
    }
    public String getCountgeki() {
        return countgeki;
    }

    public void setPerfect(String perfect) {
        this.perfect = perfect;
    }
    public String getPerfect() {
        return perfect;
    }

    public void setEnabled_mods(String enabled_mods) {
        this.enabled_mods = enabled_mods;
    }
    public String getEnabled_mods() {
        return enabled_mods;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }
    public String getPp() {
        return pp;
    }

    @Override
    public String toString() {
        return "BestMap{" +
                "beatmap_id='" + beatmap_id + '\'' +
                ", score_id='" + score_id + '\'' +
                ", score='" + score + '\'' +
                ", maxcombo='" + maxcombo + '\'' +
                ", count50='" + count50 + '\'' +
                ", count100='" + count100 + '\'' +
                ", count300='" + count300 + '\'' +
                ", countmiss='" + countmiss + '\'' +
                ", countkatu='" + countkatu + '\'' +
                ", countgeki='" + countgeki + '\'' +
                ", perfect='" + perfect + '\'' +
                ", enabled_mods='" + enabled_mods + '\'' +
                ", user_id='" + user_id + '\'' +
                ", date=" + date +
                ", rank='" + rank + '\'' +
                ", pp='" + pp + '\'' +
                '}';
    }
}
