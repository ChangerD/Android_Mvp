package com.changer.www.mvp.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.changer.www.mvp.R;
import com.changer.www.mvp.presenter.BasePresenter;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity{

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mPresenter=createPresenter();
        mPresenter.attachView((V)this);
    }

    protected abstract P createPresenter();

}
