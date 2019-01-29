package com.example.firstweek.presenter;

import com.example.firstweek.MainActivity;
import com.example.firstweek.api.Api;
import com.example.firstweek.model.GoodsModel;
import com.example.firstweek.model.IGoodsModel;

/**
 * @Auther: 李
 * @Date: 2019/1/28 08:21:58
 * @Description:
 */
public class GoodsPresenter implements IGoodsPresenter{
    private GoodsModel goodsModel;
    private MainActivity mainActivity;

    public GoodsPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        goodsModel = new GoodsModel();
    }
    /**
     * 防止内存泄露
     */
    public void destory(){
        if (mainActivity!=null){
            mainActivity = null;
        }
    }

    @Override
    public void getPresenterData() {
        goodsModel.getData(Api.UrlData, new IGoodsModel.ModelInterface() {
            @Override
            public void loadSuccess(String data) {
                mainActivity.getViewData(data);
            }

            @Override
            public void loadFailed() {

            }
        });
    }
}
