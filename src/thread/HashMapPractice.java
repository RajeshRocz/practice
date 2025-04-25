package thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapPractice {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "orange", "apple", "orange", "banana");
        Map<String, Integer> fruitCount = new HashMap<>();
        fruits.parallelStream().forEach((fruit)-> {
            fruitCount.merge(fruit, 1, Integer::sum);
        });
        System.out.println("Result1:" + fruitCount);

        Map<String, Integer> fruitCount1 = new HashMap<>();
        for (String fruit : fruits) {
            fruitCount1.compute(fruit, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println("Result2:" + fruitCount1);

        Map<String, Integer> fruitCount2 = new HashMap<>();

        for (String fruit : fruits) {
            fruitCount2.computeIfAbsent(fruit, k -> 1);
            fruitCount2.computeIfPresent(fruit, (k, v) -> v + 1);
        }
        System.out.println("Result3:"+fruitCount2);


        Map<String, Long> fruitCount3=fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Result4:"+fruitCount3);

        Map<String,Long> fruitCount4=fruits.parallelStream().collect(Collectors.groupingByConcurrent(Function.identity(),  ConcurrentHashMap::new, Collectors.counting()));
        System.out.println("Result5:"+fruitCount4);
    }
}
