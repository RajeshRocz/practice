package stream_api;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Statistics {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(3,6,3,5,2);
        List<String> names=Arrays.asList("Rajesh Rajendiran","Dhivyabharathi Rajesh","Luskhigasai Rajesh","MahiRagandith Rajendiran");


        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        LongSummaryStatistics longSummaryStatistics = numbers.stream().mapToLong(Long::valueOf).summaryStatistics();

        System.out.println("Max value:"+intSummaryStatistics.getMax());
        System.out.println("Min value:"+intSummaryStatistics.getMin());
        System.out.println("Avg value:"+intSummaryStatistics.getAverage());
        System.out.println("Sum value:"+intSummaryStatistics.getSum());
        System.out.println("Count value:"+intSummaryStatistics.getCount());


        System.out.println("Max value:"+longSummaryStatistics.getMax());
        System.out.println("Min value:"+longSummaryStatistics.getMin());
        System.out.println("Avg value:"+longSummaryStatistics.getAverage());
        System.out.println("Sum value:"+longSummaryStatistics.getSum());
        System.out.println("Count value:"+longSummaryStatistics.getCount());


        //Filter Even Numbers
        List<Integer> evenNumbers=numbers.stream().filter(num->num%2==0).toList();
        System.out.println("Even numbers:"+evenNumbers);

        // Find Maximum
        Optional<Integer> maxValue=numbers.stream().max(Integer::compare);
        System.out.println("Max value:"+maxValue.get());

        //Sum of Elements
        int sum=numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total value:"+sum);

        //List of Names to Uppercase
       // List<String> names=Arrays.asList("rajesh", "ramesh", "babu","mahi");
        List<String> upperNames=names.stream().map(String::toUpperCase).toList();
        System.out.println("Upper names:"+upperNames);

        //Sort List
        List<Integer> sorted=numbers.stream().sorted().toList();
        System.out.println("Sorted list:"+sorted);
        List<Integer> reverse=numbers.stream().sorted(Comparator.reverseOrder()).toList();
                //numbers.stream().sorted((a,b)->Integer.compare(b,a)).toList();

        System.out.println("Reverse list:"+reverse);

        //Count the number of elements in a list that are greater than 5.
        long count=numbers.stream().filter(n->n>5).count();
        System.out.println("greater than 5 count:"+count);

        //Get Distinct Elements
        List<Integer> distinctList=numbers.stream().distinct().toList();
        System.out.println("Distinct list:"+distinctList);

        //Reduce to Sum
        long reduceSum=numbers.stream().reduce(0, Integer::sum);
        System.out.println("Reduce sum:"+reduceSum);

        //Find any
        System.out.println("Find any value:"+numbers.stream().map(m-> new Random().nextInt(m)).findAny().get());

        //List first names
        List<String> firstNames=names.stream().map(name->name.split(" ")[0]).toList();
        System.out.println("First names:"+firstNames);

        //get frequency map
        Map<Long, Long> frequency=numbers.stream().map(Long::valueOf).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency:"+frequency);

        //FlatMap for Nested Lists
        List<List<Integer>> list=Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(4,5,6));
        List<Integer> nums=list.stream().flatMap(Collection::stream).sorted(Collections.reverseOrder()).toList();
        System.out.println("Flatmap result:"+nums);

        //partitioning by
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(collect);

        //) Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<String> num1=nums.stream().map(String::valueOf).filter(s->s.startsWith("1")).toList();
        System.out.println("Starts with 1:"+num1);

        //) How to find duplicate elements in a given integers list in java using Stream functions?

        Set<Integer> uniqueSet=new HashSet<>();
        List<Integer> duplicateList=numbers.stream().filter(e->!uniqueSet.add(e)).toList();
        System.out.println("Duplicate numbers:"+duplicateList);

        // Given the list of integers, find the first element of the list using Stream functions?
        Optional<Integer> firstElement=numbers.stream().findFirst();
        System.out.println("First element:"+firstElement.get());

        //Given a list of integers, find the total number of elements present in the list using Stream
        //functions?
        long totalCount=numbers.stream().count();
        System.out.println("Total count:"+totalCount);

        // Given a list of integers, find the maximum value element present in it using Stream functions?
        Optional<Integer> maxValue1=numbers.stream().max(Integer::compareTo);
        System.out.println("Max value:"+maxValue.get());

        //Write a program to print the count of each character in a String?
        String s = "string data to count each character";

        Map<Character, Long> countMap=s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println("Character count:"+countMap);
        Map<Character, Long> sortedCountMap=countMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1,LinkedHashMap::new));
        System.out.println("Sorted by frequency Character count:"+sortedCountMap);

    }
}
