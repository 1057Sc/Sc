package org.sc.multidb;

import com.alibaba.druid.pool.DruidDataSource;
import org.sc.common.DbConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private List<DataSource> roDataSources;
    private List<DataSource> woDataSources;
    private List<DataSource> rwDataSources;

    @Override
    protected Object determineCurrentLookupKey() {

        return DataSourceSelector.getCurrentKey();
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

    @Bean
    public void initDataSources(DataSource dataSource1, DataSource dataSource2) {
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(MultiDbConstants.RO, dataSource1);
        dsMap.put(MultiDbConstants.RW, dataSource2);
        dsMap.put(MultiDbConstants.WO, dataSource2);
        this.setTargetDataSources(dsMap);
    }

}
