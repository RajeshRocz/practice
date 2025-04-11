package Test;

public class ShortestPalindromeForString {
    public static void main(String[] args) {
        System.out.println("Result:"+getShortestPalindromeString("racecarb"));
    }

    private static String getShortestPalindromeString(String s){
        String original=s;
        s=new StringBuilder(s).reverse().toString();
        String temp=original+"*"+s;
        int lps[]=new int[temp.length()];
        lps[0]=0;
        int left=0;
        int right=1;

        while(right<temp.length()){

            if(temp.charAt(left)==temp.charAt(right)){
                lps[right]=left+1;
                left++;
                right++;
            }else{
                if(left!=0){
                    left=lps[left-1];
                }else{
                    lps[right]=0;
                    right++;
                }
            }
        }
        int n=temp.length();

        return s.substring(0, s.length()-lps[n-1])+original;
    }
}
