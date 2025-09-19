import java.io.*;
import java.util.*;

class Main {
    /*
     * 오른쪽을 볼 수 있는 이전 건물 높이를 단조 감소 스택에 유지한다.
     * 현재보다 작거나 같은 건물을 제거한 뒤 남은 스택 크기를 정답에 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= height) stack.pop();

            answer += stack.size();
            stack.push(height);
        }

        System.out.print(answer);
    }
}
