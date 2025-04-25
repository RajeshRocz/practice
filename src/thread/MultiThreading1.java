package thread;

/**
 ---- Multithreading ----
 1. Task: Create a Java program that spawns three threads. Each thread should increment a shared counter 1000 times.
 Use synchronization to ensure thread safety.
 2. Task: Implement a Java program using ExecutorService to execute tasks that calculate the factorial of numbers from 1 to 5.
 Use Callable and Future to retrieve results.
 3. Task: Implement a program that uses ConcurrentHashMap to store and update the frequency of words in a list of strings concurrently.
 Use advanced operations like compute and merge.
 4. Task: Implement a Java program using ExecutorService and CompletionService to execute a set of tasks that simulate network requests.
 Each task should return a response time, and the program should process the results as they become available.

 */
public class MultiThreading1 {

    private int counter=0;
    private Object lock=new Object();

    private void increament(){
        synchronized (lock){
            counter++;
        }
    }

    private int getCounter(){
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        MultiThreading1 mt=new MultiThreading1();

        Runnable rc=() ->{
                for(int i=0;i<1000;i++){
                    mt.increament();
                }
        };

        Thread t1=new Thread(rc);
        Thread t2=new Thread(rc);
        Thread t3=new Thread(rc);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Counter value:"+mt.getCounter());

    }
}
