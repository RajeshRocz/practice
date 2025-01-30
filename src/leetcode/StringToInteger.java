package leetcode;

public class StringToInteger
{
    public static void main(String[] args) {
        System.out.println("Result:"+myAtoi(" "));
    }

    public static int myAtoi(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int index=0;
        int sign=1;
        int total=0;

        while(s.charAt(index)==' '){
            index++;
            if(index>=s.length()){
                return 0;
            }
        }
        if((s.charAt(index)=='-' || s.charAt(index)=='+')){
            if (s.charAt(index)=='-'){
                index++;
                sign=-1;
            }
        }

        while(index<s.length()){
            char c=s.charAt(index);
            if((c-'0')>9 || (c-'0')<0){
                break;
            }
            int d=c-'0';
            if(Integer.MAX_VALUE/10 < total || (Integer.MAX_VALUE/10==total && Integer.MAX_VALUE%10<d)){

                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            total=10*total+d;
            index++;
        }

        return total * sign;
    }
}
