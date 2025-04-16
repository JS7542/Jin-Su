import java.io.*;
import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long weight;

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Long.compare(weight, other.weight);
        }
    }

    /*
     * 모든 간선을 가중치 오름차순으로 정렬한다.
     * 서로 다른 집합을 연결하는 간선만 선택하는 크루스칼 알고리즘을 사용한다.
     */
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertices = Integer.parseInt(st.nextToken());
            int edgesCount = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[edgesCount];

            for (int i = 0; i < edgesCount; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i] = new Edge(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Long.parseLong(st.nextToken())
                );
            }

            Arrays.sort(edges);
            parent = new int[vertices + 1];
            for (int i = 1; i <= vertices; i++) parent[i] = i;

            long total = 0;
            int selected = 0;

            for (Edge edge : edges) {
                if (!union(edge.from, edge.to)) continue;

                total += edge.weight;
                if (++selected == vertices - 1) break;
            }

            output.append('#').append(tc).append(' ').append(total).append('\n');
        }

        System.out.print(output);
    }

    static int find(int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent[value]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }
}
