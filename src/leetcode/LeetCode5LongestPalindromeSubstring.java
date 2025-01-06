package leetcode;

public class LeetCode5LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=checkFromMiddle(s, i,i);
            int len2=checkFromMiddle(s,i,i+1);
            int len=Math.max(len1, len2);
            if(len > end-start){
                start=i-((len-1)/2);
                end=i+(len/2)+1;
            }

        }
return s.substring(start, end);
    }

    public int checkFromMiddle(String s, int left, int right){
        if(s==null || right<left){
            return 0;
        }
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            right++;
            left--;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        LeetCode5LongestPalindromeSubstring leetCode5LongestPalindromeSubstring=new LeetCode5LongestPalindromeSubstring();
        String result=leetCode5LongestPalindromeSubstring.longestPalindrome("racecarb");
        System.out.println(result);
    }
}
