import java.util.*;

class Solution {
    /*
     * 마을을 정점, 도로 시간을 간선으로 보고 1번 마을에서 다익스트라를 수행한다.
     * 최단 거리가 K 이하인 마을의 개수를 센다.
     */
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int[] edge : road) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state[1])
        );
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int village = current[0];
            int cost = current[1];

            if (cost != distance[village]) continue;

            for (int[] edge : graph[village]) {
                int next = edge[0];
                int nextCost = cost + edge[1];

                if (nextCost < distance[next]) {
                    distance[next] = nextCost;
                    queue.offer(new int[]{next, nextCost});
                }
            }
        }

        int answer = 0;
        for (int village = 1; village <= N; village++) {
            if (distance[village] <= K) answer++;
        }

        return answer;
    }
}
