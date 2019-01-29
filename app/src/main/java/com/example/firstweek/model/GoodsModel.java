package com.example.firstweek.model;

import com.example.firstweek.net.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @Auther: 李
 * @Date: 2019/1/28 07:58:42
 * @Description:
 */
public class GoodsModel implements IGoodsModel{
    @Override
    public void getData(String url, final ModelInterface modelInterface) {
        OkHttp.okHttpGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                modelInterface.loadSuccess(response.body().string());
            }
        });
    }
}
