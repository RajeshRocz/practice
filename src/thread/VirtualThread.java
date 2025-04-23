package thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newVirtualThreadPerTaskExecutor();
       // CompletableFuture<Void> integerCompletableFuture1 = CompletableFuture.runAsync(()-> print(10), es);
        //CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> print(10), es);
       // integerCompletableFuture.join();
        //  integerCompletableFuture1.join();

        int threadCount=1000000;
        Long start=System.currentTimeMillis();
       List<Thread> threadList = IntStream.rangeClosed(0, threadCount).mapToObj(
                index ->
                        Thread.ofPlatform().unstarted(() ->
                        {
                            if (index == 0) {
                                System.out.println("Current Thread:" + Thread.currentThread());
                            }
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (index == 0) {
                                System.out.println("Current Thread:" + Thread.currentThread());
                            }
                        })

        ).toList();
        threadList.forEach(Thread::start);
       for(Thread thread:threadList){

               thread.join();

       }
        Long end=System.currentTimeMillis();

       System.out.println("Total time:"+(end-start));

    }

    private static int  print(int n){
        for (int i = 0; i <= n; i++) {
            System.out.println("Current Thread:"+Thread.currentThread()+" i="+i);
        }
        return 1;
    }
}
