package util.ip;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {

    @Test
    public void demo1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
    }
}
