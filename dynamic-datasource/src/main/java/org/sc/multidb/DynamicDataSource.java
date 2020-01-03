package org.sc.multidb;

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

    public void initDataSources(DataSource dataSource1, DataSource dataSource2) {
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(MultiDbConstants.RO, dataSource1);
        dsMap.put(MultiDbConstants.RW, dataSource2);
        dsMap.put(MultiDbConstants.WO, dataSource2);
        this.setTargetDataSources(dsMap);
    }

}
