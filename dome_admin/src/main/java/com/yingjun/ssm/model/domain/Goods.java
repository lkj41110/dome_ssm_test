package com.yingjun.ssm.model.domain;

import lombok.Data;

/**
 * Created by luokai on 2017/7/5.
 */
@Data
public class Goods {
    private String id;
    private String name;

    void display(){
        System.out.println("init");
    }
}
