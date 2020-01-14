package org.sc.multidb;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.sc.common.DbConfig;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("org.sc.mapper")
public class SqlSessionFactoryConfig {

    @Bean
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(MultiDbConstants.RO, dataSource1());
        dsMap.put(MultiDbConstants.RW, dataSource2());
        dsMap.put(MultiDbConstants.WO, dataSource2());
        dynamicDataSource.setTargetDataSources(dsMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        return dynamicDataSource;
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

/*
    @Bean(name = "txManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean("txAdvice")
    public TransactionInterceptor txAdvice(@Qualifier("txManager") DataSourceTransactionManager txManager) {
        // https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.transaction.interceptor.TransactionInterceptor
        return new TransactionInterceptor(txManager, source);
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(@Qualifier("txAdvice") TransactionInterceptor txAdvice) {
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setAdvice(txAdvice);
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* org.sc.*.service.*.*(..))");
        pointcutAdvisor.setPointcut(pointcut);
        return pointcutAdvisor;
    }
*/



    @Bean
    public DataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        final DbConfig dbConfig = new DbConfig();
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setDriverClassName(dbConfig.getDriverClassName());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        dataSource.setInitialSize(dbConfig.getInitialSize());
        dataSource.setMaxActive(dbConfig.getMaxActive());
        dataSource.setMinIdle(dbConfig.getMinIdle());
        dataSource.setMaxWait(dbConfig.getMaxWait());
        dataSource.setValidationQuery(dbConfig.getValidationQuery());
        dataSource.setTestOnBorrow(dbConfig.getTestOnBorrow());
        dataSource.setTestOnReturn(dbConfig.getTestOnReturn());
        dataSource.setTestWhileIdle(dbConfig.getTestWhileIdle());
        dataSource.setPoolPreparedStatements(dbConfig.getPoolPreparedStatements());
        return dataSource;
    }


    @Bean
    public DataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        final DbConfig dbConfig = new DbConfig();
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setDriverClassName(dbConfig.getDriverClassName());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        dataSource.setInitialSize(dbConfig.getInitialSize());
        dataSource.setMaxActive(dbConfig.getMaxActive());
        dataSource.setMinIdle(dbConfig.getMinIdle());
        dataSource.setMaxWait(dbConfig.getMaxWait());
        dataSource.setValidationQuery(dbConfig.getValidationQuery());
        dataSource.setTestOnBorrow(dbConfig.getTestOnBorrow());
        dataSource.setTestOnReturn(dbConfig.getTestOnReturn());
        dataSource.setTestWhileIdle(dbConfig.getTestWhileIdle());
        dataSource.setPoolPreparedStatements(dbConfig.getPoolPreparedStatements());
        return dataSource;
    }


}
