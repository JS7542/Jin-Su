import java.io.*;
import java.util.*;

class Main {
    /*
     * 가장 작은 두 카드 값을 빠르게 꺼내기 위해 최소 힙을 사용한다.
     * 두 값을 합친 수를 두 번 다시 넣는 과정을 M번 반복한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int operations = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> heap = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) heap.offer(Long.parseLong(st.nextToken()));

        while (operations-- > 0) {
            long first = heap.poll();
            long second = heap.poll();
            long merged = first + second;

            heap.offer(merged);
            heap.offer(merged);
        }

        long answer = 0;
        while (!heap.isEmpty()) answer += heap.poll();

        System.out.print(answer);
    }
}
