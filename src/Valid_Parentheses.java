/**
 * Created by xjwhhh on 2017/7/11.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses {
    //用回文的方法判断是错误的，有可能有{}()[]这样的，要使用堆栈
//    public boolean isValid(String s) {
//        char[] strs=s.toCharArray();
//        if(strs.length%2!=0){
//            return false;
//        }
//        boolean result=true;
//        for(int i=0;i<strs.length/2;i++){
//            if(!isMatched(String.valueOf(strs[i]),String.valueOf(strs[strs.length-1-i]))){
//                result=false;
//                break;
//            }
//        }
//
//        return result;
//
//    }
//
//    public boolean isMatched(String a,String b){
//        if((a.equals("(")&&b.equals(")"))
//                ||(a.equals("{")&&b.equals("}"))
//                ||(a.equals("[")&&b.equals("]"))){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for (int i = 0; i < s.length(); i++) {
            // Push any open parentheses onto stack
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }

    public static void main(String[] args) {
        Valid_Parentheses valid_parentheses = new Valid_Parentheses();
        boolean result = valid_parentheses.isValid("({})");
        System.out.print(result);
    }
}
