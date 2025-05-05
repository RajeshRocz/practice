package thread;

import java.util.List;
import java.util.stream.IntStream;



public class VirtualThread1 {
    public static void main(String[] args) {
        int threadCount = 100000;
        long start= System.currentTimeMillis();
        List<Thread> threads= IntStream.rangeClosed(1, threadCount).mapToObj(i ->

            Thread.ofVirtual().unstarted(() -> {
                        if (i == 1) {
                            System.out.println("Current Thread:" + Thread.currentThread());
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (i == 1) {
                            System.out.println("Current Thread:" + Thread.currentThread());
                        }
                        })

            ).toList();
        threads.forEach(Thread::start);
        try {
            for(Thread t: threads){
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end= System.currentTimeMillis();
        System.out.println("Time taken:"+(end-start));



    }
    }