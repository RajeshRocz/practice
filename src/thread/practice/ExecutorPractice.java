package thread.practice;

import java.util.concurrent.*;

public class ExecutorPractice {
    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());

        try(ExecutorService es= new ThreadPoolExecutor(2,3,10,TimeUnit.SECONDS, new ArrayBlockingQueue<>(2)))
            {
            Future<?> future= es.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Future");
            });
            CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Completable Future");
            });

        completableFuture.join();
        future.get();
                System.out.println(Thread.currentThread());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Thread");

    }
}
