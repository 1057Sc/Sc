package util.ip;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class Demo1 {

    @Test
    public void demo1() throws Exception {
        InetAddress address = InetAddress.getByName("10.0.100.6");
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        if (hardwareAddress != null) {
            /*
             * Extract each array of mac address and convert it
             * to hexadecimal with the following format
             * 08-00-27-DC-4A-9E.
             */
            for (int i = 0; i < hardwareAddress.length; i++) {
                System.out.format("%02X%s",
                        hardwareAddress[i], (i < hardwareAddress.length - 1) ? "-" : "");
            }
        } else {
            System.out.println("Address doesn't exist or is not " +
                    "accessible.");
        }
    }
}
