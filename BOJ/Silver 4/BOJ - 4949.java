import java.io.*;
import java.util.*;

class Main {
    /*
     * 여는 괄호는 스택에 넣고 닫는 괄호는 대응하는 여는 괄호와 짝을 확인한다.
     * 문장 끝에 스택이 비어 있어야 균형 잡힌 문자열이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (char ch : line.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        valid = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        valid = false;
                        break;
                    }
                }
            }

            output.append(valid && stack.isEmpty() ? "yes" : "no").append('\n');
        }

        System.out.print(output);
    }
}
