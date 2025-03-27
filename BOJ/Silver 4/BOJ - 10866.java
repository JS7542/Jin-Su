import java.io.*;
import java.util.*;

class Main {
    /*
     * 명령에 따라 덱의 앞·뒤 삽입, 삭제, 조회를 처리한다.
     * 덱이 비어 있는 상태의 삭제와 조회는 -1을 반환한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front" -> deque.offerFirst(Integer.parseInt(st.nextToken()));
                case "push_back" -> deque.offerLast(Integer.parseInt(st.nextToken()));
                case "pop_front" -> output.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                case "pop_back" -> output.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                case "size" -> output.append(deque.size()).append('\n');
                case "empty" -> output.append(deque.isEmpty() ? 1 : 0).append('\n');
                case "front" -> output.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                case "back" -> output.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
            }
        }

        System.out.print(output);
    }
}
