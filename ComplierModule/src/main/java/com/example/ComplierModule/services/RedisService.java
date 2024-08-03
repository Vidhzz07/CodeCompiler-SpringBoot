package com.example.ComplierModule.services;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    public <T> T get(String key,Class<T> entityClass)
    {

        try{
            Object value =  redisTemplate.opsForValue().get(key);

            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(value.toString(),entityClass);
        }catch (Exception e)
        {
            return null;
        }
    }
     
    public void set(String key,Object obj,Long ttl)
    {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonValue = objectMapper.writeValueAsString(obj);
            redisTemplate.opsForValue().set(key,jsonValue,ttl, TimeUnit.SECONDS);

        }catch (Exception e)
        {

        }
    }
}
