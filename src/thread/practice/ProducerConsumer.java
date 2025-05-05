package thread.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProducerConsumer {
     final int top;
     final int bottom;
     final int sequence;
     final List<Integer> list;

     public ProducerConsumer(int top, int bottom){
         this.top=top;
         this.bottom=bottom;
         this.sequence=0;
         this.list= Collections.synchronizedList(new ArrayList<>());

     }
    public static void main(String[] args){

    }
}
class Producer implements Runnable{

    @Override
    public void run(){

    }

}


