import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder output = new StringBuilder();

    /*
     * 인접 정점을 오름차순으로 정렬한다.
     * 재귀 DFS와 큐 BFS를 각각 수행해 방문 순서를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

        visited = new boolean[n + 1];
        dfs(start);
        output.append('\n');

        visited = new boolean[n + 1];
        bfs(start);

        System.out.print(output);
    }

    static void dfs(int node) {
        visited[node] = true;
        output.append(node).append(' ');

        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            output.append(current).append(' ');

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
