package thread;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamApi1 {
    public static void main(String args[]){
        List<Integer> numbers= Arrays.asList(2,4,3,6,4,5,7,8);
        Map<Integer, Long> factorial=numbers.parallelStream()
                .collect(Collectors.toMap(Function.identity(), (a)-> LongStream.rangeClosed(1,a).reduce((b, c)->b*c).orElse(0L),(k,v)->v, LinkedHashMap::new));
    System.out.println("Factorial details:"+factorial);

    record Transactions(int id, long amount, String type){}

        List<Transactions> transactions=List.of(
                new Transactions(1,100,"credit"),
                new Transactions(2,300,"debit"),
                new Transactions(3,400,"credit")
        );

    Map<String, Long> typeAmount=transactions.parallelStream().collect(Collectors.groupingBy(t->t.type, Collectors.summingLong(txn->txn.amount)));
    System.out.println("Type based amount:"+typeAmount);


    //Given a String, find the first repeated character in it using Stream functions?
        String input = "Java Articles are Awesome";

       char result= input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).findFirst().orElse(' ');
       System.out.println("first repeated character:"+result);

       Set<Character> charSet=new HashSet<>();

       char result1=input.chars().mapToObj(c->(char)c).filter(c->!charSet.add(c)).findFirst().orElse(' ');
        System.out.println("first repeated character1:"+result1);


        //reverse order
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        List<Integer> reversedList=myList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Reverse list:"+reversedList);

        //swap numbers
        int a=5;
        int b=8;
        System.out.println("Before swap a="+a+"  b="+b);
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println("After swap a="+a+"  b="+b);

        List<String> fruits= new ArrayList<>(List.of("orange", "apple", "banana", "melon", "gua"));
        fruits.sort(Comparator.comparingInt(String::length));
        System.out.println("Sorted fruits:"+fruits);

        String s1="abc";
        String s2="abc";
        String s3=new String("abc");
        String s4=new String("abc");
        String s5=null;

        System.out.println(s1==s2);//true
        System.out.println(s2==s3);//false
        System.out.println(s3==s4);//false
        System.out.println(s3.equals(s4));//true
        System.out.println(s5.equals(s4));//false

    }
}
