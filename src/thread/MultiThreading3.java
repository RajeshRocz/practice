package thread;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*
Task: Implement a program that uses ConcurrentHashMap to store and update the frequency of words in a list of strings concurrently.
   Use advanced operations like compute and merge.
 */
public class MultiThreading3 {
    public static void main(String[] args){
        List<String> fruits=List.of("apple","orange","banana","apple","orange","apple");
        Map<String, Long> frequencyMap=fruits.parallelStream()
                .collect(Collectors.groupingByConcurrent(str->str, ConcurrentHashMap::new, Collectors.counting()));
        System.out.println("Result frequency:"+frequencyMap);

    }
}
