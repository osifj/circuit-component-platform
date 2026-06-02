package com.dlyjcsppydspt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 电路元件参数匹配与调试平台
 * Spring Boot 启动类
 */
@SpringBootApplication
@MapperScan("com.dlyjcsppydspt.api.mapper")
public class CircuitApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitApplication.class, args);
        System.out.println("电路元件参数匹配与调试平台 启动成功！");
    }
}
