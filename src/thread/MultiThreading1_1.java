package thread;

public class MultiThreading1_1 {

    private int counter=0;
    private Object lock=new Object();

    public void increment(){
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter(){
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreading1_1 mt=new MultiThreading1_1();
        Runnable rc=()->{
            for(int i=0;i<1000;i++){
                mt.increment();
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
