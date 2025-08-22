import java.io.*;
import java.util.*;

class Main {
    /*
     * R 명령은 실제 덱을 뒤집지 않고 방향 플래그만 전환한다.
     * D 명령은 현재 방향의 앞쪽 원소를 제거하며 빈 덱이면 error를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayText = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            if (n > 0) {
                String content = arrayText.substring(1, arrayText.length() - 1);
                StringTokenizer st = new StringTokenizer(content, ",");

                while (st.hasMoreTokens()) deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean reversed = false;
            boolean error = false;

            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (reversed) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            if (error) {
                output.append("error\n");
                continue;
            }

            output.append('[');

            while (!deque.isEmpty()) {
                output.append(reversed ? deque.pollLast() : deque.pollFirst());
                if (!deque.isEmpty()) output.append(',');
            }

            output.append("]\n");
        }

        System.out.print(output);
    }
}
