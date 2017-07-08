package com.changer.www.mvp.model.modelimp;

import android.os.SystemClock;

import com.changer.www.mvp.model.imodel.ITVModel;

/**
 * Created by Changer on 2017/6/2.
 */

public class TVModelImp2 implements ITVModel {
    @Override
    public void loadTV(TVLoadListener tvLoadListener) {
        //网络访问
        SystemClock.sleep(2000);
        //加载数据
        String s = "加载成功___V2";
        //返回数据
        tvLoadListener.onComplete(s);
    }
}
