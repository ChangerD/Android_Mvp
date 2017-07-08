package com.changer.www.mvp.presenter;

/**
 * Created by 25340 on 2017/6/2.
 */

import com.changer.www.mvp.ui.iview.ITVView;
import com.changer.www.mvp.model.imodel.ITVModel;
import com.changer.www.mvp.model.modelimp.TVModelImp;

import java.lang.ref.WeakReference;

/**
 * 表示层
 */
public class TVPresenter3<T extends ITVView> {

    //View引用
    //ITVView itvView;
    protected WeakReference<T> mViewRef;

    //Model引用
    ITVModel tvModelImp=new TVModelImp();
    //ITVModel tvModelImp=new TVModelImp2();

    public TVPresenter3(){
        super();
    }

    public void fetch(){
        if(tvModelImp!=null){
            //显示进度条
            if(mViewRef.get()!=null){
                mViewRef.get().showLoading();
            }
            //加载数据
            tvModelImp.loadTV(new ITVModel.TVLoadListener() {
                @Override
                public void onComplete(String s) {
                    //返回数据
                    //显示到view
                    //容易被回收
                    if(mViewRef.get()!=null){
                        mViewRef.get().setTVData(s);
                    }
                }
            });
        }
    }

    public void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }

    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
        }
    }

}
