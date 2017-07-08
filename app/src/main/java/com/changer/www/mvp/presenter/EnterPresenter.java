package com.changer.www.mvp.presenter;

/**
 * Created by JWDING on 2017/6/2.
 */

import com.changer.www.mvp.model.imodel.IEnterModel;
import com.changer.www.mvp.model.modelimp.EnterModelImp;
import com.changer.www.mvp.ui.iview.IEnterView;

/**
 * 表示层
 */
public class EnterPresenter extends BasePresenter<IEnterView>{

    //Model引用
    IEnterModel iEnterModel=new EnterModelImp();

    public EnterPresenter(){
        super();
    }

    public void fetch(){

    }
}
