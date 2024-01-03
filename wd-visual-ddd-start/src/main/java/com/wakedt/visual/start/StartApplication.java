package com.wakedt.visual.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * wd-visual-ddd项目启动类
 */
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.wakedt.visual"})
@MapperScan("com.wakedt.visual.infrastructure.*.repository.mapper")
@EntityScan(basePackages = {"com.wakedt.visual.infrastructure.*.repository.model"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
