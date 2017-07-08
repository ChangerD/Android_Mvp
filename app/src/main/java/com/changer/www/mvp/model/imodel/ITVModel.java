package com.changer.www.mvp.model.imodel;

/**
 * Created by JWDING on 2017/6/2.
 */

public interface ITVModel {

    void loadTV(TVLoadListener tvLoadListener);

    /**
     * callback
     */
    interface TVLoadListener {
        void onComplete(String s);
    }
}
