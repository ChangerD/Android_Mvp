package com.changer.www.mvp.ui.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.changer.www.mvp.R;
import com.changer.www.mvp.ui.view.BaseActivity;
import com.changer.www.mvp.ui.iview.ITVView;
import com.changer.www.mvp.presenter.TVPresenter4;

public class MainActivity extends BaseActivity<ITVView,TVPresenter4> implements ITVView{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v1);
        textView= (TextView) findViewById(R.id.am_tv_hello);
        //new TVPresenter2(this).fetch();
        mPresenter.fetch();
    }

    @Override
    protected TVPresenter4 createPresenter() {
        return new TVPresenter4();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"loading...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTVData(String s) {
        textView.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
