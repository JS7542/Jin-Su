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
    static final long INF = Long.MAX_VALUE / 4;

    /*
     * 1, v1, v2에서 각각 다익스트라를 수행한다.
     * 1→v1→v2→N과 1→v2→v1→N 두 경로 중 가능한 최솟값을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, weight));
            graph[b].add(new Edge(a, weight));
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        long[] fromStart = dijkstra(1);
        long[] fromFirst = dijkstra(first);
        long[] fromSecond = dijkstra(second);

        long routeA = fromStart[first] + fromFirst[second] + fromSecond[n];
        long routeB = fromStart[second] + fromSecond[first] + fromFirst[n];
        long answer = Math.min(routeA, routeB);

        System.out.print(answer >= INF ? -1 : answer);
    }

    static long[] dijkstra(int start) {
        long[] distance = new long[graph.length];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<long[]> queue = new PriorityQueue<>(
                Comparator.comparingLong(state -> state[1])
        );
        queue.offer(new long[]{start, 0});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            int node = (int) current[0];
            long cost = current[1];

            if (cost != distance[node]) continue;

            for (Edge edge : graph[node]) {
                long nextCost = cost + edge.weight;

                if (nextCost < distance[edge.to]) {
                    distance[edge.to] = nextCost;
                    queue.offer(new long[]{edge.to, nextCost});
                }
            }
        }

        return distance;
    }
}
