import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    /*
     * 시작 정점에서 다익스트라 알고리즘을 수행한다.
     * 우선순위 큐에서 꺼낸 거리가 최신 거리와 같을 때만 인접 간선을 완화한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[vertices + 1];
        for (int i = 1; i <= vertices; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }

        int[] distance = new int[vertices + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state[1])
        );
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];

            if (cost != distance[node]) continue;

            for (Edge edge : graph[node]) {
                int nextCost = cost + edge.weight;

                if (nextCost < distance[edge.to]) {
                    distance[edge.to] = nextCost;
                    queue.offer(new int[]{edge.to, nextCost});
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (int node = 1; node <= vertices; node++) {
            if (distance[node] == Integer.MAX_VALUE) output.append("INF");
            else output.append(distance[node]);
            output.append('\n');
        }

        System.out.print(output);
    }
}
