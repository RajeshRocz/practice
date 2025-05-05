package thread.practice;

public class DameonThread {
    public static void main(String[] args){
        Thread t1=new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon thread running");

            }

        });

        Thread t2=new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("User thread running");

            }

        });

        t1.setDaemon(true);
        t1.start();
        t2.start();
    }

}
