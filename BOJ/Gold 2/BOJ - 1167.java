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

    static List<Edge>[] graph;

    /*
     * 임의의 정점에서 가장 먼 정점을 BFS로 찾는다.
     * 해당 정점에서 다시 가장 먼 거리까지 탐색한 값이 트리의 지름이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

        graph = new ArrayList[vertices + 1];
        for (int i = 1; i <= vertices; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(to, weight));
            }
        }

        int[] first = farthest(1);
        int[] second = farthest(first[0]);

        System.out.print(second[1]);
    }

    static int[] farthest(int start) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (distance[current] > distance[farthestNode]) {
                farthestNode = current;
            }

            for (Edge edge : graph[current]) {
                if (distance[edge.to] != -1) continue;

                distance[edge.to] = distance[current] + edge.weight;
                queue.offer(edge.to);
            }
        }

        return new int[]{farthestNode, distance[farthestNode]};
    }
}
