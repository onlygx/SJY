package com.elangzhi.sjy;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * 自定义 Application
 * Created by Administrator on 2016/12/21.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xUtil
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.

        //初始化极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);


    }
}
