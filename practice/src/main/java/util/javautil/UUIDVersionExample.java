package util.javautil;


import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class UUIDVersionExample {

    /**
     * 每次启动Jvm时按time base的方式执行10次
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            UUID uuid1 = Generators.timeBasedGenerator().generate();
            System.out.println(uuid1);
        }

/*        //Generate time-based UUID
        UUID uuid1 = Generators.timeBasedGenerator().generate();
        System.out.println("UUID : "+uuid1);
        System.out.println("UUID Version : "+uuid1.version());
        System.out.println("UUID Variant : "+uuid1.variant());

        //Generate random UUID
        UUID uuid2 = Generators.randomBasedGenerator().generate();
        System.out.println("UUID : "+uuid2);
        System.out.println("UUID Version : "+uuid2.version());
        System.out.println("UUID Variant : "+uuid2.variant());*/
    }
}
