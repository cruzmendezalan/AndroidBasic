package com.krakenlabs.androidbasic.models;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Alan Giovani Cruz Méndez on 5/1/19 9:07 AM.
 * cruzmendezalan@gmail.com
 */
public class AbstractRequest {

    public JSONObject toJson(){
        JSONObject jsonObject  = null;
        String jsonString  = "";
        try {
            Gson gson = new Gson();
            jsonString  = gson.toJson(this);
            jsonObject  = new JSONObject(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public HashMap<String,String> toMap(){
        HashMap<String,String> map = new HashMap<>();
        JSONObject jsonObject  = toJson();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()){
            String key = keys.next();
            try{
                map.put(key,jsonObject.getString(key));
             }catch (Exception e){
               e.printStackTrace();
            }
        }

        return map;
    }
}
