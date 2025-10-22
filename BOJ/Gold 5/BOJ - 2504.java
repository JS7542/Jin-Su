import java.io.*;
import java.util.*;

class Main {
    /*
     * 여는 괄호를 만날 때 현재 배수를 2 또는 3배 하고 스택에 저장한다.
     * 바로 닫히는 괄호에서만 배수를 더하고 닫힐 때 원래 배수로 복원한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int multiplier = 1;
        int answer = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                multiplier *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                multiplier *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.print(0);
                    return;
                }

                if (expression.charAt(i - 1) == '(') answer += multiplier;
                stack.pop();
                multiplier /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.print(0);
                    return;
                }

                if (expression.charAt(i - 1) == '[') answer += multiplier;
                stack.pop();
                multiplier /= 3;
            }
        }

        System.out.print(stack.isEmpty() ? answer : 0);
    }
}
