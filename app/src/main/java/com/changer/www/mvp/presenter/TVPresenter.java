package com.changer.www.mvp.presenter;

/**
 * Created by 25340 on 2017/6/2.
 */

import com.changer.www.mvp.ui.iview.ITVView;
import com.changer.www.mvp.model.imodel.ITVModel;
import com.changer.www.mvp.model.modelimp.TVModelImp;

/**
 * 表示层
 */
public class TVPresenter{

    //View引用
    ITVView itvView;

    //Model引用
    ITVModel tvModelImp=new TVModelImp();
    //ITVModel tvModelImp=new TVModelImp2();

    public TVPresenter(ITVView itvView){
        super();
        this.itvView=itvView;
    }

    public void fetch(){
        if(tvModelImp!=null){
            //显示进度条
            if(itvView!=null){
                itvView.showLoading();
            }
            //加载数据
            tvModelImp.loadTV(new ITVModel.TVLoadListener() {
                @Override
                public void onComplete(String s) {
                    //返回数据
                    //显示到view
                    itvView.setTVData(s);
                }
            });
        }
    }

}
