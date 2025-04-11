package Test;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        System.out.println("Result:"+repeatedStringMatch("abcd", "abcd"));
    }

    public static int repeatedStringMatch(String a, String b) {

        StringBuilder sb=new StringBuilder(a);
        int count=1;
        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }

        if(isPatternMatch(sb.toString(), b)){
            return count;
        }

        sb.append(a);
        count++;
       return isPatternMatch(sb.toString(), b)?count:-1;


    }

    private static boolean isPatternMatch(String s, String p){
        int[] lps=getLps(p);
        int i=0;
        int j=0;
        int n=s.length();
        int m=p.length();
        int maxCount=0;
        while(i<n){
            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }

            if(j==m){
                maxCount++;
                j=lps[j-1];
            }
        }

        return maxCount>0;

    }

    private static int[] getLps(String p){
        int n=p.length();
        int[] lps=new int[n];
        int i=0,j=1;
        lps[0]=0;
        while (j<n){
            if(p.charAt(i)==p.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }else{
                if(i!=0){
                    i=lps[i-1];
                }else{
                    lps[j]=0;
                    j++;
                }
            }
        }
        return lps;
    }
}
