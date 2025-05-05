package thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MultiThreading2_1 {
    public static void main(String[] args){
        try (ExecutorService es = Executors.newFixedThreadPool(5)) {
            Future<Integer> factorial=es.submit(()->getFactorial(5));
            System.out.println("Future 5!="+factorial.get());

            CompletableFuture<Integer> factFuture=CompletableFuture.supplyAsync(()->getFactorial(5), es);
            System.out.println("Completable Future 5!="+factFuture.join());

            CompletableFuture<Void> factRunnable=CompletableFuture.runAsync(()->{
                int fact=IntStream.rangeClosed(1,5).reduce((a,b)->a*b).orElse(0);
                System.out.println("Runnable 5!="+fact);
            }, es);
            factRunnable.join();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getFactorial(int n){
        int fact=1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
}
