package org.sc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication()
@MapperScan("org.sc")
@EnableTransactionManagement
public class ScPracticeApplication {
 /*   @Autowired
    private ElDemos demos;
*/
    public static void main(String[] args) {
        log.info("spring boot start");
        SpringApplication.run(ScPracticeApplication.class, args);
/*        demo1();
        demo2();*/
    }

/*    @Bean("redisTemplateExtension")
    @ConditionalOnMissingBean
    public RedisTemplateExtension stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplateExtension template = new RedisTemplateExtension(redisConnectionFactory);
        return template;
    }*/

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

/*    private static void demo3(){
        StandardBeanExpressionResolver standardBeanExpressionResolver = new StandardBeanExpressionResolver();
        standardBeanExpressionResolver.evaluate()
    }

    private static void demo3(){
        // can be autowired or fetched from ConfigurableApplicationContext.getBeanFactory()
        ConfigurableBeanFactory configurableBeanFactory;

        EmbeddedValueResolver embeddedValueResolver = new EmbeddedValueResolver(configurableBeanFactory);
        System.out.println(embeddedValueResolver.resolveStringValue("${someProperty}");
        System.out.println(embeddedValueResolver.resolveStringValue("#{@foo.calcValue(123)}");
    }

    private Object resolveExpression(String expression) {
        String placeholdersResolved = applicationContextProvider.getApplicationContext().getBeanFactory().resolveEmbeddedValue(expression);
        BeanExpressionResolver expressionResolver = applicationContext.getBeanFactory().getBeanExpressionResolver();
        return expressionResolver.evaluate(placeholdersResolved, new BeanExpressionContext(applicationContext.getBeanFactory(), null));
    }*/
}
