package org.sc.multidb;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession().getId();
    }

    public void initDataSources(DataSource dataSource1, DataSource dataSource2) {
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("PUBLISHER_DS", dataSource1);
        dsMap.put("ADVERTISER_DS", dataSource2);

        this.setTargetDataSources(dsMap);
    }
}
