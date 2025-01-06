package leetcode;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class LeetCode686RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {

        List<String> list=new Vector<>();
        Hashtable<String, String> hashtable = new Hashtable<>();

        StringBuilder sb=new StringBuilder(a);
        int count=1;

        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }
        if(getKmpSearch(sb.toString(), b))
        {
            return count;
        }

        sb.append(a);
        count++;

        return getKmpSearch(sb.toString(), b)?count:-1;

    }

    private boolean getKmpSearch(String s, String p){

        int[] lps=getLps(p);
        int j=0;
        int i=0;
        int n=s.length();
        int matchCount=0;
        int m=p.length();
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
            if(j==m) {
                j=lps[j-1];
                matchCount++;
            }

        }
        int board[][]=new int[8][8];
        int r=board.length;
        int c=board[0].length;
        return matchCount>0;

    }
    private int[] getLps(String p){
        int n=p.length();
        int[] lps=new int[n];
        int pos=0;
        int i=1;
        lps[0]=0;
        while(i<n){
            if(p.charAt(pos)==p.charAt(i)){
                lps[i]=pos+1;
                pos++;
                i++;
            }else{
                if(pos!=0){
                    pos=lps[pos-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        LeetCode686RepeatedStringMatch obj =new LeetCode686RepeatedStringMatch();
        int result= obj.repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(result);
    }
}
