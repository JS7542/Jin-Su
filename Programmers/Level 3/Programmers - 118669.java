import java.util.*;

class Solution {
    /*
     * 게이트들을 동시에 시작점으로 두고 경로의 최대 간선 비용을 거리로 사용하는 다익스트라를 수행한다.
     * 산봉우리에 도달하면 더 확장하지 않고 최소 intensity와 산봉우리 번호를 비교한다.
     */
    public int[] solution(
            int n,
            int[][] paths,
            int[] gates,
            int[] summits
    ) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }

        for (int[] path : paths) {
            graph[path[0]].add(new int[]{path[1], path[2]});
            graph[path[1]].add(new int[]{path[0], path[2]});
        }

        boolean[] summit = new boolean[n + 1];

        for (int node : summits) summit[node] = true;

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state[1])
        );

        for (int gate : gates) {
            intensity[gate] = 0;
            queue.offer(new int[]{gate, 0});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];

            if (cost != intensity[node] || summit[node]) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int nextCost = Math.max(cost, edge[1]);

                if (nextCost < intensity[next]) {
                    intensity[next] = nextCost;
                    queue.offer(new int[]{next, nextCost});
                }
            }
        }

        Arrays.sort(summits);

        int bestSummit = summits[0];
        int bestIntensity = intensity[bestSummit];

        for (int node : summits) {
            if (intensity[node] < bestIntensity) {
                bestSummit = node;
                bestIntensity = intensity[node];
            }
        }

        return new int[]{bestSummit, bestIntensity};
    }
}
