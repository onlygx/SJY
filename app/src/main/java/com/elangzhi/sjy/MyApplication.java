package com.elangzhi.sjy;

import android.app.Application;

import com.elangzhi.sjy.utils.Logger;

import org.xutils.BuildConfig;
import org.xutils.x;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

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
        //设置极光推送标签
        Set<String> set = new HashSet<>();
        set.add("lxy");
        TagAliasCallback tagAliasCallback = new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Logger.i(s);
            }
        };
        JPushInterface.setTags(this,set,tagAliasCallback);


    }
}
