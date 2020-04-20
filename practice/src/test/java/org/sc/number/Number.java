package org.sc.number;

import org.junit.Test;

public class Number {

    @Test
    public void demo1() {
        long l = 1;
        System.out.println(l > 0);


        long l2 = 23L;

        Long aLong = new Long(23);
        Long aLong1 = new Long(23);

        Long aLong2 = Long.valueOf(l2);
        Long aLong3 = Long.valueOf(l2);
        Long l1 = 23L;

        System.out.println(l1 == l2);
        System.out.println(aLong == l1);
        System.out.println(aLong1 == aLong);
        System.out.println(aLong2 == l2);
        System.out.println(aLong3==aLong2);
        System.out.println(aLong==aLong2);
        System.out.println(aLong1==aLong2);


    }
}
