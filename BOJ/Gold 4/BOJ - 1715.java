import java.io.*;
import java.util.*;

class Main {
    /*
     * 가장 작은 두 카드 묶음을 먼저 합쳐야 이후 비교 비용이 최소가 된다.
     * 최소 힙에서 두 묶음을 꺼내 합친 뒤 다시 넣는 과정을 반복한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.offer(Long.parseLong(br.readLine()));
        }

        long answer = 0;

        while (heap.size() > 1) {
            long first = heap.poll();
            long second = heap.poll();
            long merged = first + second;

            answer += merged;
            heap.offer(merged);
        }

        System.out.print(answer);
    }
}
