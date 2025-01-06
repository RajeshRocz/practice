package leetcode;

import java.util.LinkedList;
import java.util.List;

public class FirstHalfEqualSecondHalfNumber {

    public static void main(String[] args) {

        System.out.println(solution(134008));

    }
   private static boolean solution(int n) {


        int nofDigit=getNumberOfdigits(n);

        int firstHalf= (int) (n/Math.pow(10, nofDigit/2));
        int secodHalf= (int) ((int) n%Math.pow(10, nofDigit/2));;

        return getCountOfdigits(firstHalf)==getCountOfdigits(secodHalf);
    }

    private static int getNumberOfdigits(int t){
        int nofDigits=0;
        while(t>0){
            t=t/10;
            nofDigits++;
        }
        return nofDigits;
    }

    private static int getCountOfdigits(int t){
        int countfDigits=0;
        while(t>0){
            int d=t%10;
            t=t/10;
            countfDigits+=d;
        }
        return countfDigits;
    }
    }