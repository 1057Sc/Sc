package org.sc.multidb;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;

public class SqlSessionFactoryConfig {

    @Bean
    public DynamicDataSource dataSource() {
        return new DynamicDataSource();
    }

    @Bean
    public DbSelectorInterceptor dbSelectorInterceptor() {
        return new DbSelectorInterceptor();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPlugins(dbSelectorInterceptor());
        factoryBean.setTransactionFactory(new ManagedTransactionFactory());
        return factoryBean.getObject();
    }
}
