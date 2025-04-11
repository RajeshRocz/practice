package Test;

import java.util.Stack;

public class LongestValidParanthesis {

    public static void main(String[] args) {

        System.out.println("Result:"+getLongestValidParanthesis(")()()"));

    }

    private static int getLongestValidParanthesis(String s){
        int max=0;

        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int n=s.length();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }

        return max;
    }
}
