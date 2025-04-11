package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode30 {

    public static void main(String[] args) {

        String[] words = new String[]{"ab","ba","ba"};
        System.out.println("result = " + findSubstring("ababa", words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        int start = 0;
        List<Integer> result = new ArrayList<>();
        while((start+totalLength) <= s.length()){
            String sub=s.substring(start, (start+totalLength));
            boolean contains=true;
            for(String str:words){
                if(!sub.contains(str)){
                    contains=false;
                }else{
                    sub=removeString(sub, str);
                }
            }
            if(contains) result.add(start);
            start=start+1;
        }
return result;
    }

    private static String removeString(String fullString, String checkString){
        int index=fullString.indexOf(checkString);
        return fullString.substring(0, index)+fullString.substring((index+checkString.length()), fullString.length());
    }
}
