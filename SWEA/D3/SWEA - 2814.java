import java.io.*;
import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer;

    /*
     * 모든 정점을 시작점으로 단순 경로 DFS를 수행한다.
     * 방문한 정점은 경로에서만 표시하고 되돌아오며 최대 정점 수를 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
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

            answer = 0;
            visited = new boolean[n + 1];

            for (int start = 1; start <= n; start++) {
                visited[start] = true;
                search(start, 1);
                visited[start] = false;
            }

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int node, int length) {
        answer = Math.max(answer, length);

        for (int next : graph[node]) {
            if (visited[next]) continue;

            visited[next] = true;
            search(next, length + 1);
            visited[next] = false;
        }
    }
}
