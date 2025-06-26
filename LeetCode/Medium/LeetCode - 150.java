import java.util.*;

class Solution {
    /*
     * 숫자는 스택에 넣고 연산자를 만나면 최근 두 숫자를 꺼낸다.
     * 첫 번째 피연산자와 두 번째 피연산자의 순서를 유지해 계산 결과를 다시 넣는다.
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int second = stack.pop();
            int first = stack.pop();

            if (token.equals("+")) stack.push(first + second);
            else if (token.equals("-")) stack.push(first - second);
            else if (token.equals("*")) stack.push(first * second);
            else stack.push(first / second);
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".contains(token);
    }
}
