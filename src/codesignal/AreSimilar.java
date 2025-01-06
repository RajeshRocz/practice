package codesignal;

import java.util.ArrayList;
import java.util.List;

public class AreSimilar {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}, new int[]{1,2,3}));
    }

    private static boolean solution(int[] a, int[] b) {

        List<Integer> swapPosition= new ArrayList<>();
        for(int i=0;i<a.length;i++){

            if(a[i]!=b[i]){
                swapPosition.add(i);
            }

        }

        if(swapPosition.size() >2) return false;


        return a[swapPosition.get(0)] == b[swapPosition.get(1)] &&
                a[swapPosition.get(1)] == b[swapPosition.get(0)];


    }
}
