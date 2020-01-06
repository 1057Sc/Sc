package org.sc.multidb;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.sc.common.DbConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
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


    @Bean
    public DataSource dataSource1(){
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
    public DataSource dataSource2(){
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
