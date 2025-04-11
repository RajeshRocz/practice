package Test;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println("Result:"+repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {

        int n=s.length();
        int i=0;
        int j=1;
        int[] lps=new int[n];
        lps[i]=0;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[j]=i+1;
                i++;j++;
            }else{
                if(i!=0){
                    i=lps[i-1];
                }else{
                    lps[j]=0;
                    j++;
                }
            }
        }
        int l=lps[n-1];
        if(l==0){
            return false;
        }

        String pattern=s.substring(0,n-l);

        return l%pattern.length()==0;

    }
}
