package thread;

import java.util.OptionalInt;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/*
Task: Implement a Java program using ExecutorService to execute tasks that calculate the factorial of numbers from 1 to 5.
   Use Callable and Future to retrieve results.
 */
public class MultiThreading2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es= Executors.newSingleThreadExecutor();

        Future<Integer> fut1= es.submit(()->{
            OptionalInt reduce = IntStream.rangeClosed(1, 5).reduce((a, b) -> a * b);
            return reduce.orElse(0);

        });
        Future<Long> factFuture=es.submit(()->getFactorial(5));
        System.out.println("Factorial value:"+factFuture.get());
        System.out.println("Factorial value1:"+fut1.get());

       CompletableFuture<Integer> completable= CompletableFuture.supplyAsync(()->{
           OptionalInt reduce= IntStream.rangeClosed(1,5).reduce((a,b)->a*b);
           return reduce.orElse(0);
        }, es);

       System.out.println("Factorial result2:"+completable.get());



    }

    private static long getFactorial(long n){
        long fact=1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
}
