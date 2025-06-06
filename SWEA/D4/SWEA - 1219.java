import java.io.*;
import java.util.*;

class Solution {
    /*
     * 0번 정점에서 방향 간선을 따라 DFS를 수행한다.
     * 99번 정점에 도달할 수 있으면 1, 아니면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testNumber = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[100];

            for (int node = 0; node < 100; node++) graph[node] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for (int edge = 0; edge < edges; edge++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            boolean[] visited = new boolean[100];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            visited[0] = true;

            while (!stack.isEmpty()) {
                int current = stack.pop();

                for (int next : graph[current]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        stack.push(next);
                    }
                }
            }

            output.append('#').append(testNumber).append(' ')
                    .append(visited[99] ? 1 : 0).append('\n');
        }

        System.out.print(output);
    }
}
