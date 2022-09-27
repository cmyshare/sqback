package com.sqback.service;


import com.alibaba.fastjson.JSONArray;
import com.sqback.dao.entity.StudentScore;
import com.sqback.dao.mapper.StudentScoreMapper;
import com.sqback.utils.sqBackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class StudentScoreServiceImpl implements StudentScoreService{

    @Autowired
    public StudentScoreMapper studentScoreMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public sqBackResult findStudentScore(String sid) throws Exception {

        StudentScore studentScore = null;
        JSONArray jsonArray  = null;

//        //默认无redis
//        try {
//            studentScore = studentScoreMapper.findStudentScore(sid);
//            //将json格式数组字符串转换为json格式数组
//            jsonArray  = JSONArray.parseArray(studentScore.getScore());
//        } catch (Exception e) {
//            e.printStackTrace();
//            //当查询数据库失败后，直接返回500
//            return sqBackResult.build(500, "输入有误，请重新输入!");
//        }

        try {
            //优化从redis里读取
            ValueOperations<String,Object> valueOperations=redisTemplate.opsForValue();
            //从redis读取成绩信息
            jsonArray= (JSONArray) valueOperations.get(sid);
            //System.out.println("输出redis中的成绩信息"+jsonArray);
            if (CollectionUtils.isEmpty(jsonArray)){
                System.out.println("MYSQL");
                //如果为空，去数据库读取
                studentScore = studentScoreMapper.findStudentScore(sid);
                //将json格式数组字符串转换为json格式数组
                jsonArray  = JSONArray.parseArray(studentScore.getScore());
                //将数据加入到redis中
                valueOperations.set(sid,jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //当查询数据库失败后，直接返回500
            return sqBackResult.build(500, "输入有误，请重新输入!");
        }

//        System.out.println("无直接直接返回500");
        return sqBackResult.ok(jsonArray);
    }
}
