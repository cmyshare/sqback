package com.sqback;;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SqBackApplicationTests  {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void initConn() {

        String score = "[{\"number\":\"1\", \"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\",\"grades\":\"80.00\",\"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"2\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"3\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"4\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"5\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"6\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"}]";
        JSONArray jsonArray  = JSONArray.parseArray(score);
        String str = "";

        ValueOperations ops=redisTemplate.opsForValue();
        //ops.set("name","cmy");
        //String name = (String) ops.get("name");

        //多条
        Map<String,Object> map=new HashMap<>();

        for (int i = 18; i <=21; i++) {
            for (int j=1;j<=10000;j++){
                str = String.format("20%d07%05d",i,j);
                System.out.println(str);
                // 设置key
                map.put(str, jsonArray);
            }

        }
        ops.multiSet(map);

    }

}

