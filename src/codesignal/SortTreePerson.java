package codesignal;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortTreePerson {

    public static void main(String[] args) {
        int[] result=sortPerson(new int[]{-1, 150, 190, 170, -1, -1, 160, 180});
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortPerson(int[] a){

        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        for(int num:a){
            if(num!=-1){
                priorityQueue.add(num);
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=-1){
                a[i]=priorityQueue.poll();
            }
        }

        return a;
    }
}
