import java.io.*;
import java.util.*;

class Main {
    /*
     * 1번 컴퓨터에서 시작해 연결된 컴퓨터를 DFS로 방문한다.
     * 시작 컴퓨터를 제외한 방문 컴퓨터 수를 출력한다.
     */
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        dfs(1);

        int count = 0;
        for (int i = 2; i <= n; i++) if (visited[i]) count++;

        System.out.print(count);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
    }
}
