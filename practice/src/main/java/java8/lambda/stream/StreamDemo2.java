package java8.lambda.stream;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {

    @Test
    public void test1() {
        Stream<Integer> stream1 = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> integerStream = stream1.filter(s -> s > 5);
        integerStream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer> integers = Arrays.asList(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        integers.stream().filter(s -> s > 5);
        integers.forEach(System.out::println);
    }


    @Test
    public void sort() {
        Stream<Long> stream = Stream.of(12312312L, 12321321L, 1111000L, 2233L, 123214L);

        Stream<Long> sorted = stream.sorted(Comparator.comparingLong(o -> o));

        // sorted.forEach(System.out::println);

        //  String s = SecureUtil.md5(sorted.toString());

        // System.out.println(s);

        // System.out.println(SecureUtil.md5(stream.toString()));

        Stream<Long> stream1 = Stream.of(12312312L, 12321321L, 1111000L, 2233L, 123214L);

        System.out.println(SecureUtil.md5(stream1.toString()));


        List<Long> collect = sorted.collect(Collectors.toList());
        System.out.println(SecureUtil.md5(collect.toString()));
    }

    /**
     * getting a uniqueness value form a collection
     */
    @Test
    public void unique() {
        List<Long> longs = Arrays.asList(12312312L, 12321321L, 1111000L, 2233L, 123214L);
        HashSet<Long> longs1 = new HashSet<>(longs);
        String s = longs1.toString();
        System.out.println(SecureUtil.md5(s));

        HashSet<Long> longs2 = new HashSet<>(longs1);
        System.out.println(SecureUtil.md5(longs2.toString()));
    }

    @Test
    public void demo1() {
        List<TestObj> objList = new ArrayList<>();
/*        for (int i = 0; i < 6; i++) {
            TestObj testObj = new TestObj();
            testObj.setAge(i);
            if (i < 2) {
                testObj.setName("小猪");
                testObj.setClassNo(5);
            } else if (2 < i && i < 5) {
                testObj.setName("小狗狗");
                testObj.setClassNo(15);
            } else {
                testObj.setName("小可爱");
                testObj.setClassNo(3);
            }
            objList.add(testObj);
        }*/

        System.out.println(objList.get(0).getAge());

    }

    /**
     * java.lang.UnsupportedOperationException
     * 	at java.util.AbstractList.remove(AbstractList.java:161)
     * 	at java.util.AbstractList$Itr.remove(AbstractList.java:374)
     * 	at java.util.Collection.removeIf(Collection.java:415)
     * 	at java8.lambda.stream.StreamDemo2.remove(StreamDemo2.java:93)
     */
    @Test
    public void remove(){
        //
        List<Long> lons = Arrays.asList(12312312L, 12321321L, 1111000L, 2233L, 123214L);
        List<Long> longs = new ArrayList<>(lons);
        longs.removeIf(s -> Objects.equals(s,12312312L));
        System.out.println(longs);
    }

}
