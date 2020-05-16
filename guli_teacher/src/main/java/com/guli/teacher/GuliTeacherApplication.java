package com.guli.teacher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.guli.teacher.mapper")
@SpringBootApplication
public class GuliTeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuliTeacherApplication.class,args);
    }
}
