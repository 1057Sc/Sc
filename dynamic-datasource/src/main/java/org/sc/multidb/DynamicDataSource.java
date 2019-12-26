package org.sc.multidb;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.List;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private List<DataSource> roDataSources;
    private List<DataSource> woDataSources;
    private List<DataSource> rwDataSources;

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
