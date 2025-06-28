import java.io.*;
import java.util.*;

class Main {
    /*
     * 1부터 차례대로 스택에 넣어 목표 수열의 현재 값을 만들 때까지 push한다.
     * 스택 맨 위가 목표 값이면 pop하고, 만들 수 없으면 NO를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();
        int next = 1;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (next <= target) {
                stack.push(next++);
                output.append("+\n");
            }

            if (stack.isEmpty() || stack.peek() != target) {
                System.out.print("NO");
                return;
            }

            stack.pop();
            output.append("-\n");
        }

        System.out.print(output);
    }
}
