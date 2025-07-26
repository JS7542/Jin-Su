import java.io.*;
import java.util.*;

class Solution {
    /*
     * 여는 괄호는 스택에 저장하고 닫는 괄호는 스택 위와 올바른 쌍인지 확인한다.
     * 모든 문자를 처리한 뒤 스택이 비어 있어야 올바른 괄호 문자열이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int length = Integer.parseInt(br.readLine());
            String text = br.readLine();

            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (int index = 0; index < length; index++) {
                char ch = text.charAt(index);

                if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                    stack.push(ch);
                } else if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    valid = false;
                    break;
                }
            }

            if (!stack.isEmpty()) valid = false;

            output.append('#').append(tc).append(' ')
                    .append(valid ? 1 : 0).append('\n');
        }

        System.out.print(output);
    }

    static boolean matches(char open, char close) {
        return open == '(' && close == ')'
                || open == '[' && close == ']'
                || open == '{' && close == '}'
                || open == '<' && close == '>';
    }
}
