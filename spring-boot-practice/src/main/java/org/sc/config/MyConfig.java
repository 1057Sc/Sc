package org.sc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *  监听spring创建了哪些bean
 */
@Configuration
public class MyConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        logger.info("初始化了 bean BeanPostProcessor");
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                logger.info("加载了bean " + beanName);
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }
        };
    }

}
