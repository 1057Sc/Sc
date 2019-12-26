package util.uuid;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by duizhuang on 10/11/2019.
 */
public class DoUuid {

    @Test
    public void demo1() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");

        System.out.println(s + "::::::::::::::::::::" + s.length());
    }
}
