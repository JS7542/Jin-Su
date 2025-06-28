import java.io.*;
import java.util.*;

class Main {
    /*
     * 최대 힙을 우선순위 큐의 역순 정렬로 구현한다.
     * 0이 들어오면 최댓값을 꺼내고, 값이 있으면 힙에 추가한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                output.append(heap.isEmpty() ? 0 : heap.poll()).append('\n');
            } else {
                heap.offer(value);
            }
        }

        System.out.print(output);
    }
}
