package leetcode.patterns.topkelements;

import java.util.PriorityQueue;

public class FindTopKElements {
    public static void main(String []args){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        Integer[] nums =new Integer[]{3,6,2,7,8,5};
        //find top 3 elements
        int k=3;
       /* for (Integer num : nums) {
            minHeap.add(num);
        }
        for(int i=0;i< nums.length-k;i++){
            minHeap.poll();
        }
        */
        for (Integer num : nums) {
            minHeap.offer(num);
            if(minHeap.size()>k) {minHeap.poll();}
        }
        System.out.println(minHeap);

    }
}
