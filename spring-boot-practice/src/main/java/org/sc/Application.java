package org.sc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication()
@MapperScan("org.sc")
// @EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        log.info("spring boot start");
        SpringApplication.run(Application.class, args);
    }
}
