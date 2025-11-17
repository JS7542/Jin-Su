import java.io.*;
import java.util.*;

class Main {
    /*
     * 순간이동 비용은 0, 걷기 비용은 1이므로 0-1 BFS를 사용한다.
     * 비용 0 이동은 덱 앞에, 비용 1 이동은 덱 뒤에 넣는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        distance[start] = 0;

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            int teleport = current * 2;

            if (teleport <= 100000 && distance[teleport] > distance[current]) {
                distance[teleport] = distance[current];
                deque.offerFirst(teleport);
            }

            for (int next : new int[]{current - 1, current + 1}) {
                if (next < 0 || next > 100000) continue;

                if (distance[next] > distance[current] + 1) {
                    distance[next] = distance[current] + 1;
                    deque.offerLast(next);
                }
            }
        }

        System.out.print(distance[target]);
    }
}
