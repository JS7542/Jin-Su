import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 사람을 시작점으로 BFS를 수행해 다른 사람까지의 최단 거리를 합산한다.
     * 거리 합이 가장 작은 사람 중 번호가 작은 사람을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = 1;
        int best = Integer.MAX_VALUE;

        for (int start = 1; start <= n; start++) {
            int[] distance = new int[n + 1];
            Arrays.fill(distance, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            distance[start] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (distance[next] != -1) continue;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }

            int sum = 0;
            for (int node = 1; node <= n; node++) sum += distance[node];

            if (sum < best) {
                best = sum;
                answer = start;
            }
        }

        System.out.print(answer);
    }
}
