package thread.practice;

public class WaitAndNotify {

    private final static Object lock=new Object();

    public static void main(String[] args){
        Thread t1=new Thread(WaitAndNotify::firstMethod);
        Thread t2=new Thread(WaitAndNotify::secondMethod);
        t1.start();
        t2.start();
    }

    private static void firstMethod(){
        synchronized(lock){
            System.out.println("Inside from firstMethod");

            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Back to firstMethod");
        }
    }

    private static void secondMethod(){
        synchronized (lock){
            System.out.println("Call from firstMethod inside secondMethod");
            lock.notify();
            System.out.println("After notify from secondMethod");
        }
    }
}
