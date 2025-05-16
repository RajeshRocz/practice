package thread.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                System.out.println("Produced:" + count);
                if(blockingQueue.size()<5) {
                    blockingQueue.add(count);
                    count++;
                }

                Thread.sleep(500);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

class Consumer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                int value = blockingQueue.take();
                System.out.println("Consumed value:" + value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


