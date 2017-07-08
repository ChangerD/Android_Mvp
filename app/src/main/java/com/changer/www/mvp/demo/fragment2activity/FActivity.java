package com.changer.www.mvp.demo.fragment2activity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

import com.changer.www.mvp.ui.view.BaseActivity;
import com.changer.www.mvp.ui.iview.ITVView;
import com.changer.www.mvp.R;
import com.changer.www.mvp.presenter.TVPresenter4;

public class FActivity extends BaseActivity<ITVView,TVPresenter4> implements ITVView{

    private TextView textView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        textView= (TextView) findViewById(R.id.fb_tv_sayhello);
        fragmentManager=getSupportFragmentManager();
        //fragmentManager.beginTransaction().
        mPresenter.fetch();
    }

    @Override
    protected TVPresenter4 createPresenter() {
        return new TVPresenter4();
    }

    @Override
    public void showLoading() {
        //Toast.makeText(this,"loading...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTVData(String s) {
        textView.setText(s);
    }
}
