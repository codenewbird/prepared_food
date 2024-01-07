package com.zjx.rbacredis.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Component
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper(){
        super();
        //去掉默认时间戳格式
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置东八区
        setTimeZone(TimeZone.getTimeZone("GTM+8"));
        //设置日期转化
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //设置输入：禁止把pojo中值为null的字段映射到json串
        configure(SerializationFeature.WRITE_NULL_MAP_VALUES,false);
        //空值不序列化
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //反序列化是以toString()来输出，默认false，及默认以name()来输出
        configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,true);
    }
}
