package com.elangzhi.sjy.utils;

import android.content.SharedPreferences;

import com.elangzhi.sjy.beans.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据存储Util
 * Created by Administrator on 2016/12/21.
 */

public class DbUtil {

    /**
     * 获取html img标签中的src
     * @param imgDOM html
     * @return src
     */
    public static String getSrc(String imgDOM){
        if(imgDOM == null || imgDOM.equals("")){return null;}

        Pattern p = Pattern.compile("<img(.[^>]*?)src=('|\")(.*?)('|\").*?>",Pattern.CASE_INSENSITIVE);
        //String str = imgDOM;
        Matcher m = p.matcher(imgDOM);
        if(m.find()){
            return m.group(3);
        }
        return null;
    }

    /**
     * 获取指定分类数据
     * @param varietyId 品种分类
     * @param periodId 周期分类
     * @return 结果
     */
    public static List<Trade> searchByType(String varietyId, String periodId,List<Trade> tradeList){
        List<Trade> temp = new ArrayList<>();
        for(Trade trade : tradeList){
            if(trade.getVarietyId().equals(varietyId) && trade.getPeriodId().equals(periodId)){
                temp.add(trade);
            }
        }
        return temp;
    }



}
