package Test;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println("Result:"+getLongestPalindromeString("racecarb"));
    }

    private static String getLongestPalindromeString(String s){


        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){

            int len1=getLengthOfPalindrome(s,i,i);
            int len2=getLengthOfPalindrome(s, i, i+1);
            int len=Math.max(len1,len2);

            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2+1;
            }

        }

        return s.substring(start, end);
    }

    private static int getLengthOfPalindrome(String s, int left, int right){
        if(s==null || right>left){
            return 0;
        }

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}
