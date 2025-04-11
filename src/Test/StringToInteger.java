package Test;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("Result:"+stringToInteger("123"));
    }

    private static int stringToInteger(String s){
        int index=0;
        int total=0;
        int sign=1;
        while(s.charAt(index)==' '){

            index++;
            if(index>=s.length()){
                return 0;
            }
        }

        if(s.charAt(index)=='-' || s.charAt(index)=='+'){
            if(s.charAt(index)=='-'){
                sign=-1;
            }
            index++;
        }

        while (index<s.length()){
            char c=s.charAt(index);

            if(c-'0'>9 || c-'0'<0){
                break;
            }
            int d=c-'0';

            if(Integer.MAX_VALUE/10<total || (Integer.MAX_VALUE/10==total && Integer.MAX_VALUE%10>d)){
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            total=total*10+d;
            index++;
        }

        return total;
    }
}
