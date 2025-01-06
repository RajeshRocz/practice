package leetcode.patterns.topkelements;

public class LeetCode2269 {
    public static void main(String[] args) {
        LeetCode2269 leetCode2269=new LeetCode2269();
        System.out.println(leetCode2269.divisorSubstrings(430043, 2));
    }
    public int divisorSubstrings(int num, int k) {
        String numString = String.valueOf(num);
        int result=0;
        for(int i=0;i<=numString.length()-k;i++){
            String t=numString.substring(i,i+k);
            int temp= Integer.parseInt(t);
            if(temp!=0 && num%temp==0){
                result++;
            }

        }
return result;
    }
}
