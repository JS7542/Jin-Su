import java.io.*;
import java.util.*;

class Main {
    /*
     * 커서 왼쪽과 오른쪽 문자를 두 개의 덱으로 나눈다.
     * 이동·삭제·입력 명령을 처리한 뒤 오른쪽 덱을 순서대로 이어 붙인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            String input = br.readLine();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (char command : input.toCharArray()) {
                if (command == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (command == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (command == '-') {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(command);
                }
            }

            while (!left.isEmpty()) right.push(left.pop());
            while (!right.isEmpty()) output.append(right.pop());
            output.append('\n');
        }

        System.out.print(output);
    }
}
