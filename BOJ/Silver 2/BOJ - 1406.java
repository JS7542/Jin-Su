import java.io.*;
import java.util.*;

class Main {
    /*
     * 커서 왼쪽과 오른쪽 문자를 두 개의 스택으로 나눈다.
     * 명령에 따라 문자를 두 스택 사이로 이동하거나 삽입·삭제한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char ch : br.readLine().toCharArray()) left.push(ch);

        int commands = Integer.parseInt(br.readLine());

        while (commands-- > 0) {
            String line = br.readLine();
            char command = line.charAt(0);

            if (command == 'L') {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (command == 'D') {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (command == 'B') {
                if (!left.isEmpty()) left.pop();
            } else {
                left.push(line.charAt(2));
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) answer.append(right.pop());

        System.out.print(answer);
    }
}
