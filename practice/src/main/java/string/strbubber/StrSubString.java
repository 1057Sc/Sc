package string.strbubber;

import cn.hutool.core.lang.UUID;
import org.junit.Test;

public class StrSubString {

    @Test
    public void demo1() {
        String s = "sss" + UUID.fastUUID().toString();
        System.out.println(s.substring(0, s.length() - 36));
    }
}
