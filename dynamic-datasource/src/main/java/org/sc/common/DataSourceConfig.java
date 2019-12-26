package org.sc.common;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DbConfig dbConfig = new DbConfig();
        dataSourceBuilder.driverClassName(dbConfig.getDriverClassName());
        dataSourceBuilder.url(dbConfig.getUrl());
        dataSourceBuilder.username(dbConfig.getUsername());
        dataSourceBuilder.password(dbConfig.getPassword());
        return dataSourceBuilder.build();
    }

    @Bean(name = "salveDataSource")
    public DataSource getSalveDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DbConfig dbConfig = new DbConfig();
        dataSourceBuilder.driverClassName(dbConfig.getDriverClassName());
        dataSourceBuilder.url(dbConfig.getUrl());
        dataSourceBuilder.username(dbConfig.getUsername());
        dataSourceBuilder.password(dbConfig.getPassword());
        return dataSourceBuilder.build();
}
}
