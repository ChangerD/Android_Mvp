package com.changer.www.mvp.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by JWDING on 2017/6/5.
 */

public class MJsonRequest {

    private  Map<String,Object> params;

    private  RequestBody requestBody;

    public  RequestBody getRequestBody(){
            if(requestBody==null){
                /*MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                JSONObject json=new JSONObject();
                try {
                    json.put("params",getParams().toString());
                    requestBody = RequestBody.create(JSON, json.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                FormBody.Builder builder =new  FormBody.Builder();
                requestBody=builder.add("params",new JSONObject(getParams()).toString()).build();
            }
            return requestBody;
    }

    public  Map<String,Object> getParams(){
            if(params==null){
                params=new HashMap<>();
            }
            return params;
    }

    public  MJsonRequest addParam(String key,Object value){
        getParams().put(key,value);
        return this;
    }

    public  MJsonRequest removeParam(String key){
        getParams().remove(key);
        return this;
    }

    public MJsonRequest setParams(Map<String,Object> _params){
        params=_params;
        return this;
    }
}
