package string;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(Character ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            } else if(!s.isEmpty() && isPairParenthesis(s.peek(),ch)){
                s.pop();
            }else
                return false;
        }
        return s.isEmpty();
    }

    public static boolean isPairParenthesis(Character a, Character b){
        return a == '(' && b == ')' || a=='{' && b == '}' || a=='[' && b==']';
    }

    public static void main(String[] args) {
        String s = "[{()}";
        System.out.println(isValid(s));
    }
}
