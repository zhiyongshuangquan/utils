package com.xfc.utils;

import android.app.Application;

import com.xfc.util.LogUtil;

/**
 * Created by Administrator on 2017/11/27.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //进行控住log是否打印数据
        LogUtil.isDebug = true;
    }
}
