import java.io.*;
import java.util.*;

class Main {
    /*
     * 방문하지 않은 정점에서 BFS를 시작해 연결 요소의 정점 수와 간선 수를 센다.
     * 무방향 연결 요소가 트리이려면 간선 수가 정점 수보다 정확히 1 작아야 한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int test = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertices = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            if (vertices == 0 && edges == 0) break;

            List<Integer>[] graph = new ArrayList[vertices + 1];

            for (int node = 1; node <= vertices; node++) graph[node] = new ArrayList<>();

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                graph[first].add(second);
                graph[second].add(first);
            }

            boolean[] visited = new boolean[vertices + 1];
            int trees = 0;

            for (int start = 1; start <= vertices; start++) {
                if (visited[start]) continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(start);
                visited[start] = true;

                int vertexCount = 0;
                int edgeCountTwice = 0;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    vertexCount++;
                    edgeCountTwice += graph[current].size();

                    for (int next : graph[current]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }

                if (edgeCountTwice / 2 == vertexCount - 1) trees++;
            }

            output.append("Case ").append(test++).append(": ");

            if (trees == 0) output.append("No trees.");
            else if (trees == 1) output.append("There is one tree.");
            else output.append("A forest of ").append(trees).append(" trees.");

            output.append('\n');
        }

        System.out.print(output);
    }
}
