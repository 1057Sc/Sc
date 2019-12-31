package org.sc.common;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.sc.multidb.DbSelectorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DataSource salveDataSource;


    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setPlugins(this.getDbSelectorInterceptor());
        return sqlSessionFactoryBean;
    }


    @Bean
    public DbSelectorInterceptor getDbSelectorInterceptor(){
        return new DbSelectorInterceptor();
    }
}
