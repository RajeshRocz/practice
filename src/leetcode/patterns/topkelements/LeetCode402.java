package leetcode.patterns.topkelements;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {

        char c=num.charAt(0);

        for(int i=1;i<num.length()-k;i++){
            int t=Character.getNumericValue(c);
            if(Character.getNumericValue(c)<t);

        }
        return num;
    }
}
