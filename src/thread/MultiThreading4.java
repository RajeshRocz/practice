package thread;

import java.util.Random;
import java.util.concurrent.*;

/*
Task: Implement a Java program using ExecutorService and CompletionService to execute a set of tasks that simulate network requests.
   Each task should return a response time, and the program should process the results as they become available.
 */
public class MultiThreading4 implements Callable<Integer> {
        private final String requestName;
        private final Random random=new Random();

    public MultiThreading4(String requestName) {
        this.requestName = requestName;
    }


    @Override
    public Integer call() throws Exception {
        int responseTime=500+ random.nextInt(1000);
        Thread.sleep(responseTime);
        System.out.println(requestName+" completed in "+responseTime+"ms");
        return responseTime;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int task=3;
        ExecutorService es= Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService=new ExecutorCompletionService<>(es);
        for(int i=0;i<task;i++){
            completionService.submit(new MultiThreading4("Request-"+(i+1)));
        }

        for(int i=0;i<task;i++){
            Future<Integer> future=completionService.take();
            int responseTime=future.get();
            System.out.println("Processed result:"+responseTime+"ms");
        }
        es.shutdown();

    }
}
