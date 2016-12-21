package com.elangzhi.sjy.utils;

import com.elangzhi.sjy.beans.Period;
import com.elangzhi.sjy.beans.Variety;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型集合
 * Created by GaoXiang on 2016/12/21.
 */
public class TypeUtil {

    private static List<Variety> varietyList;
    private static List<Period> periodList;

    // 初始化分类
    static {
        varietyList = new ArrayList<>();
        varietyList.add(new Variety("1","黄金"));
        varietyList.add(new Variety("2","白银"));
        varietyList.add(new Variety("3","原油"));
        varietyList.add(new Variety("4","铜"));
        varietyList.add(new Variety("5","美日"));
        varietyList.add(new Variety("6","欧美"));
        varietyList.add(new Variety("7","镑美"));
        varietyList.add(new Variety("8","标普"));
        varietyList.add(new Variety("9","镑日"));


        periodList = new ArrayList<>();
        periodList.add(new Period("1","M5"));
        periodList.add(new Period("2","M15"));
        periodList.add(new Period("3","M30"));
        periodList.add(new Period("4","H1"));
        periodList.add(new Period("5","H4"));
        periodList.add(new Period("6","D1"));
        periodList.add(new Period("7","W1"));
        periodList.add(new Period("8","MN"));

    }

    public static List<Variety> getVarietyList() {
        return varietyList;
    }

    public void setVarietyList(List<Variety> varietyList) {
        this.varietyList = varietyList;
    }

    public static List<Period> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Period> periodList) {
        this.periodList = periodList;
    }
}


