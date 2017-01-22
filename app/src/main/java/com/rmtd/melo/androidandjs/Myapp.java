package com.rmtd.melo.androidandjs;

import android.app.Application;

import com.amap.api.navi.AMapNavi;

/**
 * Created by duyanfeng on 2017/1/20.
 */
public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AMapNavi.setApiKey(this, "9470def8ebb4482030e9c6a4f55f27cc");
    }
}
