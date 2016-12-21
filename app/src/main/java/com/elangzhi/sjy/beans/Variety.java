package com.elangzhi.sjy.beans;

/**
 * 品种实体
 * Created by Administrator on 2016/12/21.
 */
public class Variety{
    private String id;
    private String name;

    public Variety(){}

    public Variety(String id,String name){
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
