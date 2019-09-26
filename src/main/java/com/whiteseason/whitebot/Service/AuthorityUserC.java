package com.whiteseason.whitebot.Service;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;

public class AuthorityUserC {
    private HashMap whitebook = new HashMap<String,String>();
    private static String appDirectory;

    public AuthorityUserC(String appDirectory){
        this.appDirectory = appDirectory;
        whitebook = readbook(new File(appDirectory+"whitebook.properties"),whitebook);
    }

    private HashMap<String,String> readbook(File file,HashMap<String,String> map){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String json = "";
            String flag;
            while((flag = br.readLine()) != null){
                json+=flag;
            }
            map = new Gson().fromJson(json,HashMap.class);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
//    private boolean writeBook(long qq,String value,HashMap<String,String> map,File file){
//        try{
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
    public static boolean writWhitebook(long qq, String value){
        return false;
    }
    public HashMap<String,String> getWhitebook(){
        return whitebook;
    }
}
