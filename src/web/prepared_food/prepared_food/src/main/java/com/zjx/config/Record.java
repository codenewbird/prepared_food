package com.zjx.config;

import org.springframework.stereotype.Component;

@Component
public class Record {
    private int count;

    public void add(){
        count++;
        System.out.println("count:"+count);
    }

}
