package lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {


    private static List<TestObj> objList = new ArrayList<>();


    public static void main(String[] args) {

        sort();
    }

    static {

        for (int i = 0; i < 6; i++) {
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
        }

    }

    public static void collectors() {

        // 转为list
        List<Integer> collect = objList.stream().map(TestObj::getAge).collect(Collectors.toList());

        Set<Integer> collect1 = objList.stream().map(TestObj::getAge).collect(Collectors.toSet());

        Map<String, Integer> collect2 = objList.stream().collect(Collectors.toMap(TestObj::getName, TestObj::getAge));

        // 聚合操作
        Long collect3 = objList.stream().collect(Collectors.counting());

        Long collect5 = objList.stream().count();

 /*       Collection.stream().count() → Collection.size(). In Java 8 Collection.stream().count() actually iterates over collection elements to count them while Collection.size() is much faster for most of collections.
                Stream.flatMap(Collection::stream).count() → Stream.mapToLong(Collection::size).sum(). Similarly there's no need to iterate all the nested collections. Instead, their sizes could be summed up.
        collection.stream().filter(o -> ...).count() > 0 → collection.stream().anyMatch(o -> ...)
        collection.stream().filter(o -> ...).count() == 0 → collection.stream().noneMatch(o -> ...)*/

        Integer integer = objList.stream().map(TestObj::getAge).collect(Collectors.maxBy(Integer::compareTo)).get();

        Optional<Integer> max = objList.stream().map(TestObj::getAge).max(Integer::compareTo);

        objList.stream().collect(Collectors.averagingDouble(TestObj::getAge));

        System.out.println(1);

    }

    public static void sort() {
      /*  objList.stream().sorted(
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
                .forEach(System.out::println);*/


       /* List<TestObj> collect = objList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o2.getAge() - o1.getAge();
                    }
                }
        ).collect(Collectors.toList());*/

       for (TestObj obj : objList){
           System.out.println(obj.toString());
       }

        System.out.println("----------------------------------");

        List<TestObj> collect = objList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getClassNo().equals(o2.getClassNo())){
                        return o2.getAge() - o1.getAge();
                    }else {
                        return o2.getClassNo() - o1.getClassNo();
                    }
                })
                .collect(Collectors.toList());

        for (TestObj testObj : collect){
            System.out.println(testObj.toString());
        }


        System.out.println();
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

    public static void test() {

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

    public static void reduce() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        int sum = numbers.stream().reduce(0, (x, y) -> x + y);


        int multiplication = numbers.stream().reduce(1, (x, y) -> x * y);

        int max = numbers.parallelStream().reduce(10, Integer::max);


        System.out.println(sum + "::::::" + multiplication + "::::::::" + max);
    }
}
