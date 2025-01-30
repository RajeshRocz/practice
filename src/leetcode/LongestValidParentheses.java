package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println("Result:"+getLongestValidParentheses(")()()"));
    }
//Leetcode32
    public static int getLongestValidParentheses(String s){

        Stack<Integer> stack= new Stack<>();
        stack.push(-1);
        if (null==s) return 0;
        // "()"
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch== '('){
                stack.push(i);

            }else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;
    }
}
