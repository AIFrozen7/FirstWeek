package com.example.firstweek.net;


import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @Auther: 李
 * @Date: 2019/1/28 08:03:02
 * @Description:
 */
public class OkHttp {

    private static OkHttpClient okHttpClient;
    private static Request request;
    private static OkHttpClient client;
    private static RequestBody requestBody;
    private static Request request1;

    public static void okHttpGet(String url, Callback callback){
        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .method("GET",null)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    public static void okHttpPost(String url,String name,String pwd,Callback callback){
        client = new OkHttpClient();
        requestBody = new FormBody.Builder()
                .add("phone",name)
                .add("pwd",pwd)
                .build();
        request1 = new Request.Builder()
                .url(url)
                .post(OkHttp.requestBody)
                .build();
        client.newCall(request1).enqueue(callback);
    }
}
