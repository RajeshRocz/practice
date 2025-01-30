
package leetcode;

import java.util.Stack;

public class StringBalancedParenthesis {

    public static void main(String[] args) {
        System.out.println("Result:"+checkParenthesis("(()())"));
    }

    private static boolean checkParenthesis(String s){

        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else{
                if(stack.isEmpty() || stack.pop()!=')'){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
