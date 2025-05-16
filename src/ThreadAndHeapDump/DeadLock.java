package ThreadAndHeapDump;

public class DeadLock {
    public static void main(String[] args){
        String pen="pen";
        String write="write";
        Thread t1=new Thread(()->{
            synchronized (pen){
                System.out.println("Entered into pen Thread1");
                synchronized (write){
                    System.out.println("Entered into write into Thread1");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (write){
                System.out.println("Entered into write Thread2");
                synchronized (pen){
                    System.out.println("Entered into pen Thread2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
