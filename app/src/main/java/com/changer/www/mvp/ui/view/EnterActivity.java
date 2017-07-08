package com.changer.www.mvp.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.changer.www.mvp.R;
import com.changer.www.mvp.presenter.BasePresenter;
import com.changer.www.mvp.presenter.EnterPresenter;
import com.changer.www.mvp.ui.iview.IEnterView;

public class EnterActivity extends BaseActivity implements IEnterView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    @Override
    protected BasePresenter createPresenter() {
        return new EnterPresenter();
    }

}
