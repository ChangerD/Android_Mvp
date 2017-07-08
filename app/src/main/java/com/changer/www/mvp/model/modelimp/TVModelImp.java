package com.changer.www.mvp.model.modelimp;

import com.changer.www.mvp.model.imodel.ITVModel;

/**
 * Created by Changer on 2017/6/2.
 */

public class TVModelImp implements ITVModel {
    @Override
    public void loadTV(TVLoadListener tvLoadListener) {
        //加载数据
        String s = "加载成功";
        //返回数据
        tvLoadListener.onComplete(s);
    }
}
