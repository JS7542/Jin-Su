import java.io.*;
import java.util.*;

class Main {
    /*
     * 절댓값이 작은 수를 우선하고, 절댓값이 같으면 실제 값이 작은 수를 우선한다.
     * 사용자 정의 비교 기준으로 우선순위 큐를 구성한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
            return absCompare != 0 ? absCompare : Integer.compare(a, b);
        });

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
