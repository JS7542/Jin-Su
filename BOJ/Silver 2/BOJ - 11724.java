import java.io.*;
import java.util.*;

class Main {
    /*
     * 모든 정점을 순회하며 방문하지 않은 정점에서 DFS를 시작한다.
     * DFS가 시작된 횟수가 그래프의 연결 요소 개수다.
     */
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        int components = 0;

        for (int node = 1; node <= n; node++) {
            if (!visited[node]) {
                components++;
                dfs(node);
            }
        }

        System.out.print(components);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) if (!visited[next]) dfs(next);
    }
}
