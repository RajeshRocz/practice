package leetcode;

public class LeetCode459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int n=s.length();
        int[] lps=new int[n];
        int pos=0;
        int i=1;
        lps[0]=0;
        while(i<n){
            if(s.charAt(pos)==s.charAt(i)){
                lps[i]=pos+1;
                pos++;
                i++;
            }else{
                if(pos!=0) pos=lps[pos-1];
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int l=lps[n-1];

        if(l==0) return false;
        String pattern=s.substring(0, n-l);
        return l%pattern.length()==0;

    }


    public static void main(String[] args) {
        LeetCode459RepeatedSubstringPattern obj= new LeetCode459RepeatedSubstringPattern();
        boolean result = obj.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(result);
    }
}
