//package com.sqback.utils;
//
//import com.alibaba.fastjson.JSONArray;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.Pipeline;
//
//import java.time.Duration;
//import java.time.Instant;
//import java.util.List;
//
//public class redisTest {
//    @Autowired
//    private static RedisTemplate redisTemplate;
//    public static void main(String[] args) {
//
//        String score = "[{\"number\":\"1\", \"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\",\"grades\":\"80.00\",\"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"2\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"3\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"4\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"5\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"6\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"}]";
////        JSONArray jsonArray  = JSONArray.parseArray(score);
//        String str = "";
//
//        RedisSerializer keySerializer = redisTemplate.getKeySerializer();
//        RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
//
//
//        JedisPoolConfig poolConfig=new JedisPoolConfig();
//        // 最大空闲连接数
//        poolConfig.setMaxIdle(50);
//        // 最大连接数
//        poolConfig.setMaxTotal(100);
//        // 最大等待毫秒数
//        poolConfig.setMaxWaitMillis(20000);
//        // 使用配置连接池
//        JedisPool pool=new JedisPool(poolConfig, "139.196.72.132", 6379);
//        // 获取Redis连接
//        Jedis jedis=pool.getResource();
//        // 配置客户端登录密码
//        jedis.auth("root");
//        Instant start=Instant.now();
//        // 开启流水线
//        Pipeline pipeline=jedis.pipelined();
////        // 测试10万字符串数据的写入和读取
////        for(int i=1;i<=100000;i++){
////            // 设置key
////            pipeline.set("pipe-key-"+i, i+"");
////            // 读取key
////            pipeline.get("pipe-key-"+i);
////        }
//        for (int i = 1; i < 10000; i++) {
//            str = String.format("202307%04d",i);
//            System.out.println(str);
//            // 设置key
//            pipeline.set("sid"+str, score);
//            // 读取key
//            pipeline.get("sid"+str);
//
//        }
//
//        // 返回结果.将执行过的命令以list集合返回结果.
//        List<Object> result=pipeline.syncAndReturnAll();
//        // 关闭连接
//        jedis.close();
//        pool.close();
//        Instant end=Instant.now();
//        System.out.println("一共运行了"+result.size()+"个命令");
//        System.out.println("计算耗时:"+ Duration.between(start, end).toMillis()+"毫秒");
//    }
//}
