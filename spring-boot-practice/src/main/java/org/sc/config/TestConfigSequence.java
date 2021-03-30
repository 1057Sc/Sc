package org.sc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author zhuqingxin
 * @date 2021/3/29
 */
@Component
@Import({TestConfigSequence.Config2.class, TestConfigSequence.Config1.class})
public class TestConfigSequence {

    public class Config1 {
        @Bean
        public Config1 config1() {
            return new Config1();
        }

    }


    public class Config2 {
        @Bean
        public Config2 config2() {
            return new Config2();
        }

    }
}
