package com.elangzhi.sjy;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 自定义 Application
 * Created by Administrator on 2016/12/21.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
