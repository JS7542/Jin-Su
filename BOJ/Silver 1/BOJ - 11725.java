import java.io.*;
import java.util.*;

class Main {
    /*
     * 1번 노드를 루트로 BFS를 수행한다.
     * 처음 방문한 인접 노드의 부모를 현재 노드로 기록한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] parent = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        parent[1] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (parent[next] != 0) continue;

                parent[next] = current;
                queue.offer(next);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int node = 2; node <= n; node++) {
            output.append(parent[node]).append('\n');
        }

        System.out.print(output);
    }
}
