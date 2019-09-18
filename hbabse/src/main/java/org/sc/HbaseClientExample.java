package org.sc;

import com.google.protobuf.ServiceException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/**
 * Created by Sc on 8/30/2019.
 */
public class HbaseClientExample {

    public static void main(String[] args) throws IOException, ServiceException {
        new HbaseClientExample().connect();
    }

    private void connect() throws IOException, ServiceException {
        Configuration config = HBaseConfiguration.create();

        String path = this.getClass().getClassLoader().getResource("hbase-site.xml").getPath();
        config.addResource(new Path(path));


        //config.set("hbase.master", "10.0.100.235:60000");
        //config.addResource(new Path("/usr/local/hbase/hbase/conf/hbase-site.xml"));

        try {
            HBaseAdmin.checkHBaseAvailable(config);
        } catch (MasterNotRunningException e) {
            System.out.println("HBase is not running." + e.getMessage());
            return;
        }

        HBaseClientOperations HBaseClientOperations = new HBaseClientOperations();
        HBaseClientOperations.run(config);
    }
}
