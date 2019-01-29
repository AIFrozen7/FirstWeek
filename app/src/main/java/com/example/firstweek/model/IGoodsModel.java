package com.example.firstweek.model;

/**
 * @Auther: 李
 * @Date: 2019/1/28 07:58:33
 * @Description:
 */
public interface IGoodsModel {
    void getData(String url,ModelInterface modelInterface);
    interface ModelInterface{
        void loadSuccess(String data);
        void loadFailed();
    }
}
