package com.elangzhi.sjy.utils;

import android.util.Log;

/**
 * 日志输出工具
 * Created by GaoXiang
 */

public class Logger {

    private static String TAG = "时交易";

    /**
     * info
     * @param message
     */
    public static void i(String message){
        Log.i(TAG,message);
    }

    /**
     * debug
     * @param message
     */
    public static void d(String message){
        Log.d(TAG,message);
    }

    /**
     * error
     * @param message
     */
    public static void e(String message){
        Log.e(TAG,message);
    }

    /**
     * warn
     * @param message
     */
    public static void w(String message){
        Log.w(TAG,message);
    }

    /**
     * verbose
     * @param message
     */
    public static void v(String message){
        Log.v(TAG,message);
    }

}
