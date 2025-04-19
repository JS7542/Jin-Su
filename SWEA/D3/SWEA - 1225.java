import java.io.*;
import java.util.*;

class Solution {
    /*
     * 큐의 맨 앞 숫자에서 1부터 5까지 순서대로 뺀다.
     * 결과가 0 이하가 되면 0을 넣고 종료하며 큐 순서를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) queue.offer(Integer.parseInt(st.nextToken()));

            int decrease = 1;

            while (true) {
                int value = queue.poll() - decrease;

                if (value <= 0) {
                    queue.offer(0);
                    break;
                }

                queue.offer(value);
                decrease = decrease % 5 + 1;
            }

            output.append('#').append(tc).append(' ');
            for (int value : queue) output.append(value).append(' ');
            output.append('\n');
        }

        System.out.print(output);
    }
}
