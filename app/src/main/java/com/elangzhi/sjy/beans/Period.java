package com.elangzhi.sjy.beans;

/**
 * 周期实体
 * Created by Administrator on 2016/12/21.
 */
public class Period{
    private String id;
    private String name;

    public Period(){}

    public Period(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
