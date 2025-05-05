package thread.practice;

public class NormalMultiThread {
    public static void main(String[] args){
        Thread t1=new Thread(new ThreadOne());
        Runnable r2= new ThreadTwo();
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();

        Thread t3=new Thread(() -> {
            for(int i=1;i<=10;i++){
                System.out.println("From ThreadThree:"+i+" Current thread:"+Thread.currentThread());
            }
        });

        t3.start();
    }

}

class ThreadOne implements Runnable{

    @Override
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("From ThreadOne:"+i+" Current thread:"+Thread.currentThread());
        }
    }
}

class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=15;i++){
            System.out.println("From ThreadTwo:"+i+" Current thread:"+Thread.currentThread());
        }
    }

}
