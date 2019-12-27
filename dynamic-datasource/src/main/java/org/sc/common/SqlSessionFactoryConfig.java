package org.sc.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
public class SqlSessionFactoryConfig {


    /**
     * https://www.programcreek.com/java-api-examples/?code=helloworldtang%2Fspringboot-multi-datasource%2Fspringboot-multi-datasource-master%2Fmybatis-aop%2Fsrc%2Fmain%2Fjava%2Fcom%2Ftangcheng%2Fdatasources%2Faop%2Fconfig%2FMyBatisConfig.java#
     *
     *
     * @param routingDataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(AbstractRoutingDataSource routingDataSource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(routingDataSource);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        factoryBean.setTypeAliasesPackage("com.tangcheng.datasources.aop.model");// 指定基包
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));//
        return factoryBean.getObject();
    }
}
