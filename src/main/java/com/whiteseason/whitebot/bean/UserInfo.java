package com.whiteseason.whitebot.bean;

import java.util.Date;
import java.util.List;

public class UserInfo {

	private String user_id;
	private String username;
	private Date join_date;
	private String count300;
	private String count100;
	private String count50;
	private String playcount;
	private String ranked_score;
	private String total_score;
	private String pp_rank;
	private String level;
	private String pp_raw;
	private String accuracy;
	private String count_rank_ss;
	private String count_rank_ssh;
	private String count_rank_s;
	private String count_rank_sh;
	private String count_rank_a;
	private String country;
	private String total_seconds_played;
	private String pp_country_rank;
	private List<Events> events;
	public  UserInfo(){
		super();
	}

	public UserInfo(String user_id, String username, String pp_rank, String pp_raw, String accuracy, String country,
			String pp_country_rank) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.pp_rank = pp_rank;
		this.pp_raw = pp_raw;
		this.accuracy = accuracy;
		this.country = country;
		this.pp_country_rank = pp_country_rank;
	}
	

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", username=" + username + ", join_date=" + join_date + ", count300="
				+ count300 + ", count100=" + count100 + ", count50=" + count50 + ", playcount=" + playcount
				+ ", ranked_score=" + ranked_score + ", total_score=" + total_score + ", pp_rank=" + pp_rank
				+ ", level=" + level + ", pp_raw=" + pp_raw + ", accuracy=" + accuracy + ", count_rank_ss="
				+ count_rank_ss + ", count_rank_ssh=" + count_rank_ssh + ", count_rank_s=" + count_rank_s
				+ ", count_rank_sh=" + count_rank_sh + ", count_rank_a=" + count_rank_a + ", country=" + country
				+ ", total_seconds_played=" + total_seconds_played + ", pp_country_rank=" + pp_country_rank
				+ ", events=" + events + "]";
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setCount300(String count300) {
		this.count300 = count300;
	}

	public String getCount300() {
		return count300;
	}

	public void setCount100(String count100) {
		this.count100 = count100;
	}

	public String getCount100() {
		return count100;
	}

	public void setCount50(String count50) {
		this.count50 = count50;
	}

	public String getCount50() {
		return count50;
	}

	public void setPlaycount(String playcount) {
		this.playcount = playcount;
	}

	public String getPlaycount() {
		return playcount;
	}

	public void setRanked_score(String ranked_score) {
		this.ranked_score = ranked_score;
	}

	public String getRanked_score() {
		return ranked_score;
	}

	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}

	public String getTotal_score() {
		return total_score;
	}

	public void setPp_rank(String pp_rank) {
		this.pp_rank = pp_rank;
	}

	public String getPp_rank() {
		return pp_rank;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setPp_raw(String pp_raw) {
		this.pp_raw = pp_raw;
	}

	public String getPp_raw() {
		return pp_raw;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setCount_rank_ss(String count_rank_ss) {
		this.count_rank_ss = count_rank_ss;
	}

	public String getCount_rank_ss() {
		return count_rank_ss;
	}

	public void setCount_rank_ssh(String count_rank_ssh) {
		this.count_rank_ssh = count_rank_ssh;
	}

	public String getCount_rank_ssh() {
		return count_rank_ssh;
	}

	public void setCount_rank_s(String count_rank_s) {
		this.count_rank_s = count_rank_s;
	}

	public String getCount_rank_s() {
		return count_rank_s;
	}

	public void setCount_rank_sh(String count_rank_sh) {
		this.count_rank_sh = count_rank_sh;
	}

	public String getCount_rank_sh() {
		return count_rank_sh;
	}

	public void setCount_rank_a(String count_rank_a) {
		this.count_rank_a = count_rank_a;
	}

	public String getCount_rank_a() {
		return count_rank_a;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setTotal_seconds_played(String total_seconds_played) {
		this.total_seconds_played = total_seconds_played;
	}

	public String getTotal_seconds_played() {
		return total_seconds_played;
	}

	public void setPp_country_rank(String pp_country_rank) {
		this.pp_country_rank = pp_country_rank;
	}

	public String getPp_country_rank() {
		return pp_country_rank;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public List<Events> getEvents() {
		return events;
	}

}

class Events {

	private String display_html;
	private String beatmap_id;
	private String beatmapset_id;
	private Date date;
	private String epicfactor;

	public void setDisplay_html(String display_html) {
		this.display_html = display_html;
	}

	public String getDisplay_html() {
		return display_html;
	}

	public void setBeatmap_id(String beatmap_id) {
		this.beatmap_id = beatmap_id;
	}

	public String getBeatmap_id() {
		return beatmap_id;
	}

	public void setBeatmapset_id(String beatmapset_id) {
		this.beatmapset_id = beatmapset_id;
	}

	public String getBeatmapset_id() {
		return beatmapset_id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setEpicfactor(String epicfactor) {
		this.epicfactor = epicfactor;
	}

	public String getEpicfactor() {
		return epicfactor;
	}

}