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
    static int farthestNode;
    static int farthestDistance;

    /*
     * 임의의 정점에서 가장 먼 정점을 찾는다.
     * 그 정점에서 다시 가장 먼 거리까지 탐색하면 트리의 지름이 된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].add(new Edge(child, weight));
            graph[child].add(new Edge(parent, weight));
        }

        search(1, 0, 0);
        int start = farthestNode;

        farthestDistance = 0;
        search(start, 0, 0);

        System.out.print(farthestDistance);
    }

    static void search(int node, int parent, int distance) {
        if (distance > farthestDistance) {
            farthestDistance = distance;
            farthestNode = node;
        }

        for (Edge edge : graph[node]) {
            if (edge.to != parent) {
                search(edge.to, node, distance + edge.weight);
            }
        }
    }
}
