package thread;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.function.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapPractice1 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "apple", "banana", "apple", "orange");
        Map<String, Integer> frequency1 = new HashMap<>();

        //using merge
        fruits.forEach(fruit ->
                frequency1.merge(fruit, 1, Integer::sum)
        );
        System.out.println("Frequency Using merge:" + frequency1);

        Map<String, Integer> frequency2 = new HashMap<>();
        //using compute
        fruits.forEach(fruit ->
                frequency2.compute(fruit, (k, v) -> v != null ? v + 1 : 1)
        );

        System.out.println("Frequency Using compute:"+frequency2);

        Map<String,Integer> frequency3=new HashMap<>();
        fruits.forEach(fruit->
                {
                    if(frequency3.containsKey(fruit)){
                        frequency3.computeIfPresent(fruit,(k,v)->v+1);
                    }else{
                        frequency3.computeIfAbsent(fruit, k->1);
                    }
                }
                );
        System.out.println("Frequency using compute ifabsent and ifPresent:"+frequency3);

        //use collectors with counting
        Map<String, Long> frequency4=fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency using collectors:"+frequency4);


        //use concurrent
        Map<String, Long> frequency5=fruits.parallelStream().collect(Collectors.groupingByConcurrent(Function.identity(), ConcurrentHashMap::new, Collectors.counting()));
        System.out.println("Frequency using concurrent:"+frequency5);
    }
}
