package com.changer.www.mvp.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by JWDING on 2017/6/2.
 */

public class BasePresenter<V> {

    protected WeakReference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
        }
    }

    protected V getView(){
        return mViewRef.get();
    }

}
