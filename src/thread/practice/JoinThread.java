package thread.practice;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            for(int i=1;i<=5;i++){
                System.out.println("Thread one executed.");
            }
        });

        Thread t2=new Thread(()->{
            for(int i=1;i<=5;i++){
                System.out.println("Thread two executed.");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Thread execution completed!");
    }
}


