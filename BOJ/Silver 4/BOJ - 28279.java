import java.io.*;
import java.util.*;

class Main {
    /*
     * 명령별로 덱의 앞·뒤 삽입, 삭제, 조회를 처리한다.
     * 삭제나 조회 대상이 없으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1 -> deque.offerFirst(Integer.parseInt(st.nextToken()));
                case 2 -> deque.offerLast(Integer.parseInt(st.nextToken()));
                case 3 -> output.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                case 4 -> output.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                case 5 -> output.append(deque.size()).append('\n');
                case 6 -> output.append(deque.isEmpty() ? 1 : 0).append('\n');
                case 7 -> output.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                case 8 -> output.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
            }
        }

        System.out.print(output);
    }
}
