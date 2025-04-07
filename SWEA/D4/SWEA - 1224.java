import java.io.*;
import java.util.*;

class Solution {
    /*
     * 연산자 우선순위와 괄호를 고려해 두 스택으로 중위식을 계산한다.
     * 더 높은 우선순위 연산자는 먼저 적용하고 닫는 괄호에서 여는 괄호까지 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String expression = br.readLine();

            Deque<Integer> numbers = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();

            for (char token : expression.toCharArray()) {
                if (Character.isDigit(token)) {
                    numbers.push(token - '0');
                } else if (token == '(') {
                    operators.push(token);
                } else if (token == ')') {
                    while (operators.peek() != '(') {
                        calculate(numbers, operators.pop());
                    }
                    operators.pop();
                } else {
                    while (!operators.isEmpty()
                            && operators.peek() != '('
                            && priority(operators.peek()) >= priority(token)) {
                        calculate(numbers, operators.pop());
                    }
                    operators.push(token);
                }
            }

            while (!operators.isEmpty()) calculate(numbers, operators.pop());

            output.append('#').append(tc).append(' ')
                    .append(numbers.pop()).append('\n');
        }

        System.out.print(output);
    }

    private static int priority(char operator) {
        return operator == '*' ? 2 : 1;
    }

    private static void calculate(Deque<Integer> numbers, char operator) {
        int second = numbers.pop();
        int first = numbers.pop();

        numbers.push(operator == '+'
                ? first + second
                : first * second);
    }
}
