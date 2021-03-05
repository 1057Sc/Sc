package org.sc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.sc.redis.RedisTemplateExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication()
@MapperScan("org.sc")
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        log.info("spring boot start");
        SpringApplication.run(Application.class, args);
    }


    @Bean("redisTemplateExtension")
    @ConditionalOnMissingBean
    public RedisTemplateExtension stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplateExtension template = new RedisTemplateExtension(redisConnectionFactory);
        return template;
    }
}
