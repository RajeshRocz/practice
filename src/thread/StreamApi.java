package thread;

import java.util.List;

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

    public static void main(String[] args){
        List<Integer> numbers=List.of(3,5,2,6,7,8,9,2);
        int evenSquaresSum=numbers.stream().filter(num->num%2==0).map(n->n*n).mapToInt(Integer::intValue).sum();
        System.out.println("Even numbers squares:"+evenSquaresSum);
    }
}
