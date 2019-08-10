package lambda.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {


    private static List<TestObj> objList = new ArrayList<>();


    public static void main(String[] args) {

        filter();
    }

    static {

        for (int i = 0; i < 6; i++) {
            TestObj testObj = new TestObj();
            testObj.setAge(i);
            testObj.setName("name" + i);
            objList.add(testObj);
        }

    }

    public static void collectors() {

        // 转为list
        List<Integer> collect = objList.stream().map(TestObj::getAge).collect(Collectors.toList());

        Set<Integer> collect1 = objList.stream().map(TestObj::getAge).collect(Collectors.toSet());

        Map<String, Integer> collect2 = objList.stream().collect(Collectors.toMap(TestObj::getName, TestObj::getAge));

        // 聚合操作
        Long collect3 = objList.stream().collect(Collectors.counting());

        Optional<Integer> collect4 = objList.stream().map(TestObj::getAge).collect(Collectors.maxBy(Integer::compareTo));

    }

    public static void sort() {
        objList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getAge() > o2.getAge()) {
                        return o1.getAge();
                    } else {
                        return o2.getAge();
                    }
                }
        );

        objList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o2.getAge() - o1.getAge();
                    }
                }
        )
                .map(TestObj::getAge)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void filter() {

        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);

        Stream<Integer> limit = stream.filter(s -> s > 5)
                .distinct()
                .skip(2)
                .limit(3);

        limit.forEach(System.out::println);

        List<Integer> collect = limit.collect(Collectors.toList());

    }

    public static void test(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list.stream().findFirst().get(); //1
        Integer findAny = list.stream().findAny().get(); //1

        long count = list.stream().count(); //5
        Integer max = list.stream().max(Integer::compareTo).get(); //5
        Integer min = list.stream().min(Integer::compareTo).get(); //1
    }
}
