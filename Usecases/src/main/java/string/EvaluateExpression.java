package string;

import java.util.Stack;

public class EvaluateExpression {

    public static int evaluate(String s) {
        char[] exp = s.toCharArray();
        Stack<Integer> value = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == ' ')
                continue;
            if (exp[i] >= '0' && exp[i] <= '9') {
                StringBuffer bf = new StringBuffer();
                while (i < exp.length && exp[i] >= '0' && exp[i] <= '9')
                    bf.append(exp[i++]);
                value.push(Integer.parseInt(bf.toString()));
            } else if (exp[i] == '(') {
                operator.push(exp[i]);
            } else if (exp[i] == ')') {
                value.push(applyOp(operator.pop(), value.pop(), value.pop()));
                operator.pop();
            } else if (exp[i] == '*' || exp[i] == '/' || exp[i] == '+' || exp[i] == '-') {
                while (!operator.empty() && hasPrecedence(exp[i], operator.peek()))
                    value.push(applyOp(operator.pop(), value.pop(), value.pop()));
                operator.push(exp[i]);
            }
        }

        while (!operator.empty())
            value.push(applyOp(operator.pop(), value.pop(), value.pop()));

        return value.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' && op1 == '/') && (op2 == '+' && op2 == '-')){
            return false;
        } else{
            return true;
        }

    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("10 + 2 * 6"));
        System.out.println(evaluate("100 * 2 + 12"));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
    }
}
