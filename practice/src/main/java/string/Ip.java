package string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class Ip {

    @Test
    public void demo1() {
        String ip = "192.1.1.1";
        String ip1 = "192.1.1.1";
        System.out.println(StringUtils.equals(ip, ip1));
    }
}
