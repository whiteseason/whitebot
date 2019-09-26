package com.whiteseason.whitebot.util.osu;

import com.google.gson.Gson;
import com.whiteseason.whitebot.bean.BestMap;
import com.whiteseason.whitebot.bean.MapInfo;
import com.whiteseason.whitebot.bean.User;
import com.whiteseason.whitebot.bean.UserInfo;
import com.whiteseason.whitebot.util.HttpRequest;

import java.util.Objects;


public class OsuInfoGet {
	// osuapikey
	static String key = "bce5c7c2976939396b6e7891a34a4f37a14a431e";
	// api访问地址
	static String Api = "https://osu.ppy.sh/api/";
	// 细分功能
	static String get_beatmaps = Api + "get_beatmaps";
	static String get_user = Api + "get_user";
	static String get_scores = Api + "get_scores";
	static String get_user_best = Api + "get_user_best";
	static String get_user_recent = Api + "get_user_recent";
	Gson gson = new Gson();

	private static String hadleString(String str){
		// 这里被坑了好几天，烦死，ppy返回的数据有中括号，gson用fromJson会把他读成一个数组，就有点麻烦
		if(str == "[]" || str == null)  {
			str = null;
			return str;
		}
		str = str.substring(1, str.length() - 1);
		return str;
	}

	public static UserInfo getUser(String name, int mode) {
		String string = hadleString(HttpRequest.sendPost(get_user,
				"k=" + key + "&u=" + name + "&m=" + mode));
		if(string == "") return null;
		return new Gson().fromJson(string,UserInfo.class);
	}

	public static BestMap[] UserBsetMap(User user, int mode){
		String string = HttpRequest.sendPost(get_user_best,
				"k="+key+"&u="+user.getUser_id()+ "&m=" + mode);
		if(string == "") return null;
		return new Gson().fromJson(string,BestMap[].class);
	}
}
