import java.util.*;

class Solution {
    /*
     * 트리를 루트화하고 각 노드가 꺼진 경우와 켜진 경우의 최소 등대 수를 DP로 계산한다.
     * 현재 노드가 꺼지면 모든 자식은 켜야 하고, 켜지면 자식별 두 상태 중 작은 값을 선택한다.
     */
    private List<Integer>[] graph;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) graph[node] = new ArrayList<>();

        for (int[] edge : lighthouse) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] result = search(1, 0);
        return Math.min(result[0], result[1]);
    }

    private int[] search(int node, int parent) {
        int off = 0;
        int on = 1;

        for (int next : graph[node]) {
            if (next == parent) continue;

            int[] child = search(next, node);
            off += child[1];
            on += Math.min(child[0], child[1]);
        }

        return new int[]{off, on};
    }
}
