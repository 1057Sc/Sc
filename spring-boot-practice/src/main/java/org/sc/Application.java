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
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
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
        demo1();
        demo2();
    }


    @Bean("redisTemplateExtension")
    @ConditionalOnMissingBean
    public RedisTemplateExtension stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplateExtension template = new RedisTemplateExtension(redisConnectionFactory);
        return template;
    }

    private static void demo1(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    private static void demo2(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name == 'Nikola Tesla'");
        EvaluationContext context = new StandardEvaluationContext();
        boolean result = exp.getValue(context, Boolean.class);  // evaluates to true
        System.out.println(result);
    }
}
