package leetcode;

public class LeetCode214ShortestPalindrome {
        public String shortestPalindrome(String s) {
            String original=s;
            StringBuilder sb=new StringBuilder(s);
            s=sb.reverse().toString();
            String temp=original+"*"+s;
            int n= temp.length();
            int[] lps=new int[n];
            int pos=0;
            int i=1;
            lps[0]=0;
            while(i<n){
                if(temp.charAt(pos)== temp.charAt(i)){
                    lps[i]=pos+1;
                    i++;
                    pos++;
                }else{
                    if(pos!=0){
                        pos=lps[pos-1];
                    }else{
                        lps[i]=0;
                        i++;
                    }
                }
            }

            return s.substring(0,original.length()-lps[n-1])+original;

        }

    public static void main(String[] args) {
        LeetCode5LongestPalindromeSubstring leetCode5LongestPalindromeSubstring=new LeetCode5LongestPalindromeSubstring();
        String result=leetCode5LongestPalindromeSubstring.longestPalindrome("racecarb");
        System.out.println(result);
    }
}
