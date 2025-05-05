package thread;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
5. Task: Write a program that uses the Stream API to process a list of integers. Filter out odd numbers, square the remaining numbers,
   and then find the sum of these squares.
6. Task: Implement a program that uses parallel streams to process a large list of integers, calculating their factorial and collecting
   the results using a custom collector.
7. Task: Implement a Java program that processes a list of transactions. Each transaction has an ID, amount, and type (e.g., "credit" or "debit").
   Use a custom collector to group transactions by type and calculate the total amount for each type.
8. Task: Write a program that processes a list of users, where each user has a list of orders. Each order may or may not have a discount.
   Use flatMap to extract all discounts and calculate the average discount using Optional.
 */
public class StreamApi {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 2, 6, 7, 8, 9, 2);
        int evenSquaresSum = numbers.stream().filter(num -> num % 2 == 0).map(n -> n * n).mapToInt(Integer::intValue).sum();
        System.out.println("Even numbers squares:" + evenSquaresSum);

        List<Integer> numbers1 = List.of(3, 5, 2, 6, 7, 8, 9);
        Map<Integer, Long> factorials = numbers1.parallelStream()
                .collect(Collectors.toMap(Function.identity(), a -> LongStream.rangeClosed(1L, a).reduce((b, c) -> b * c).orElse(0L), (k, v) -> v, LinkedHashMap::new));
        System.out.println("Factorials map:" + factorials);


        record Transactions(int id, long amount, String type) {
        }
        Stream<Transactions> stream = Stream.of(new Transactions(1, 100, "credit"), new Transactions(2, 200, "credit"), new Transactions(3, 300, "debit"));
        Map<String, Long> amountSumMap = stream.parallel().collect(Collectors.groupingBy(Transactions::type, Collectors.summingLong(Transactions::amount)));
        System.out.println("Amount sum map:" + amountSumMap);

    }
}
