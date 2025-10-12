import java.io.*;
import java.util.*;

class Main {
    /*
     * 현재 위치에서 -1, +1, ×2로 이동하는 상태 그래프를 BFS로 탐색한다.
     * 처음 동생 위치에 도달한 시간이 최소 이동 시간이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] distance = new int[100001];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                System.out.print(distance[current]);
                return;
            }

            int[] nextValues = {current - 1, current + 1, current * 2};

            for (int next : nextValues) {
                if (next < 0 || next > 100000 || distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }
    }
}
