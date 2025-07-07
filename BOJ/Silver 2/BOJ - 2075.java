import java.io.*;
import java.util.*;

class Main {
    /*
     * 크기 N의 최소 힙만 유지한다.
     * 모든 수를 넣되 N개를 넘으면 최솟값을 제거하면 루트가 N번째 큰 수가 된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 0; c < n; c++) {
                heap.offer(Integer.parseInt(st.nextToken()));
                if (heap.size() > n) heap.poll();
            }
        }

        System.out.print(heap.peek());
    }
}
