import java.io.*;
import java.util.*;

class Main {
    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    /*
     * 현재 탑보다 낮은 탑은 이후 신호도 받을 수 없으므로 스택에서 제거한다.
     * 제거 후 스택 맨 위가 현재 신호를 받는 가장 가까운 왼쪽 탑이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Tower> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int index = 1; index <= n; index++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < height) stack.pop();

            output.append(stack.isEmpty() ? 0 : stack.peek().index).append(' ');
            stack.push(new Tower(index, height));
        }

        System.out.print(output);
    }
}
