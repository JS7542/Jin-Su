import java.io.*;
import java.util.*;

class Main {
    /*
     * 명령에 따라 큐의 삽입, 삭제, 크기, 공백 여부와 양 끝 값을 처리한다.
     * 비어 있는 상태에서 삭제나 조회를 하면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" -> queue.offerLast(Integer.parseInt(st.nextToken()));
                case "pop" -> output.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
                case "size" -> output.append(queue.size()).append('\n');
                case "empty" -> output.append(queue.isEmpty() ? 1 : 0).append('\n');
                case "front" -> output.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
                case "back" -> output.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(output);
    }
}
