package com.cduestc.keep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cduestc.keep.mapper")//自动路由到我们的mapper文件，spring boot就可以扫描到mapper文件
public class KeepApplication{
    public static void main(String[] args) {
        SpringApplication.run(KeepApplication.class, args);
    }

}
