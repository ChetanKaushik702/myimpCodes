package cp;

import java.io.*;
import java.util.ArrayDeque;

public class TransformExpression {

    int getPriority(char ch) {
        switch(ch) {
            case '(':
                return 3;
            case '^':
                return 2;
            case '*':
            case '/':
                return 1;
            case '-':
            case '+':
                return 0;
            default:
                return 4;
        }
    }

    String RPS(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        char c[] = s.toCharArray();
        
        for (char ch : c) {
            // if ch is an operand
            if (ch >= 'a' && ch <= 'z') str.append(ch);
            else {
                // if ch == ')'
                if (ch == ')')
                    while (!stack.isEmpty()) {
                        if (stack.peekLast() == '(') {
                            stack.pollLast();
                            break;
                        }
                        str.append(stack.pollLast());
                    }
                else {
                    if (ch == '(')
                        stack.offerLast(ch);
                    else {
                        while (!stack.isEmpty() && getPriority(stack.peekLast()) < getPriority(ch))
                            str.append(stack.pollLast());
                        stack.offerLast(ch);
                    }
                }
            }
            // System.out.println(ch + "\t" + stack);
        }
        while (!stack.isEmpty()) {
            if (stack.peekLast() == '(')
                stack.pollLast();
            else
                str.append(stack.pollLast());
        }
        return str.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            TransformExpression exp = new TransformExpression();
            System.out.println(exp.RPS(s));
        }
        br.close();
    }
}
