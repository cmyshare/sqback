package com.sqback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}) 关闭自动扫描数据库
@SpringBootApplication
//@MapperScan("com.sqback.dao.mapper")
public class SqBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqBackApplication.class, args);
    }

}
