package com.zjx.rbacredis.configuration;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.rbacredis.entity.LoginUser;
import com.zjx.rbacredis.entity.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


/**
 * Redis工具类
 */

@Component
public final class RedisUtil{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object object, Long expire) {
        try {
            if(expire > 0){
                redisTemplate.opsForValue().set(key,object,expire,TimeUnit.SECONDS);
            }else{
                set(key,object);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object get(String key){
        Object object = redisTemplate.opsForValue().get(key);
        return object;
    }

    public Set<String> getKeyList(String keyPrefix){
        Set<String> keylsit = redisTemplate.keys(keyPrefix);
        return keylsit;
    }

    public boolean remove(String key){
        try{
            boolean delete = redisTemplate.delete(key);
            return delete;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addTTL(String key, Long ttl) {
        try{
            boolean returnValue = redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
            return returnValue;
        }catch (Exception e){
            return false;
        }
    }
}
