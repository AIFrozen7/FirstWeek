package com.example.firstweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.firstweek.adapter.GVAdapter;
import com.example.firstweek.bean.JsonBean;
import com.example.firstweek.presenter.GoodsPresenter;
import com.example.firstweek.view.IGoodsView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGoodsView {

    private GridView gridView;
    private GoodsPresenter goodsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        goodsPresenter = new GoodsPresenter(this);
        goodsPresenter.getPresenterData();
    }

    @Override
    public void getViewData(String data) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(data, JsonBean.class);
        final List<JsonBean.DataBean> data1 = jsonBean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GVAdapter gvAdapter = new GVAdapter(data1,MainActivity.this);
                gridView.setAdapter(gvAdapter);
            }
        });
    }

    /**
     * 防止内存泄露
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (goodsPresenter!=null){
            goodsPresenter.destory();
        }
    }
}
