package java8.lambda.stream;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {


    private static List<TestObj> objList = new ArrayList<>();


 /*   public static void main(String[] args) {

        distinct();
    }*/

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

        Map<String, Integer> collect2 = objList.stream().collect(Collectors.toMap(TestObj::getName, TestObj::getAge, (o1, o2) -> o1));

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

    public static void distinct() {
        // array of list  , distinct
        ArrayList<TestObj> collect4 = objList.stream().
                collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(TestObj::getClassNo))), ArrayList::new));
        collect4.forEach(System.out::println);
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

        for (TestObj obj : objList) {
            System.out.println(obj.toString());
        }

        System.out.println("----------------------------------");

        List<TestObj> collect = objList.stream().sorted(
                        (o1, o2) -> {
                            if (o1.getClassNo().equals(o2.getClassNo())) {
                                return o2.getAge() - o1.getAge();
                            } else {
                                return o2.getClassNo() - o1.getClassNo();
                            }
                        })
                .collect(Collectors.toList());

        for (TestObj testObj : collect) {
            System.out.println(testObj.toString());
        }


        System.out.println();
    }

    @Test
    public void filter() {

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


    @Test
    public void sort1() {
        List<Integer> collect = Stream.of(0, 1, 9, 7, 4, 2).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        System.out.println(collect.toString());

        Map<String, Integer> sortedMap = new HashMap<>();
        sortedMap.put("str1", 1);
        sortedMap.put("str5", 5);
        sortedMap.put("str3", 3);
        sortedMap.put("str4", 4);
        sortedMap.put("str6", 6);
        sortedMap.put("str2", 2);

        List<String> strings = new ArrayList<>(sortedMap.keySet());

        List<String> collect1 = strings.stream().sorted(Comparator.comparingInt(sortedMap::get)).collect(Collectors.toList());
        System.out.println(collect1.toString());

    }

    @Test
    public void MapStream() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Set<Map.Entry<String, Integer>> entries1 = map.entrySet();
        Integer reduce = entries.stream().map(Map.Entry::getValue).reduce(1, (x, y) -> (x * y));
        System.out.println(reduce);
    }

    @Test
    public void remove() {

    }


    @Test
    public void collect() {
        List<Integer> collect = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        List<Integer> collect1 = IntStream.range(10, 20).boxed().collect(Collectors.toList());

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(collect);
        lists.add(collect1);
        ArrayList<Integer> collect2 = lists.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        System.out.println(JSONUtil.toJsonStr(collect2));

        ArrayList<Object> collect3 = lists.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(JSONUtil.toJsonStr(collect3));


        ArrayList<Object> collect4 = lists.stream().collect(ArrayList::new, ArrayList::add, ArrayList::add);
        System.out.println(JSONUtil.toJsonStr(collect4));


        ArrayList<Object> collect5 = lists.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::add);
        System.out.println(JSONUtil.toJsonStr(collect5));
    }

    @Test
    public void collect1() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        // 使用方法引用来传递行为, 更加清晰易懂, new(新建) -> add(累加) -> addAll(合并)
     /*   List<String> list2 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println(JSONUtil.toJsonStr(list2));*/

        String concat = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(concat);
    }

    @Test
    public void parallelStream() {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5).parallel()
                .map(i -> i + 1).collect(Collectors.toList());
        System.out.println(collect);
    }
}
