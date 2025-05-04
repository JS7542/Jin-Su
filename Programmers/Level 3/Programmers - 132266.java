import java.util.*;

class Solution {
    /*
     * 목적지에서 모든 지역으로 역방향 BFS를 수행한다.
     * 무방향 도로이므로 한 번의 BFS 결과로 각 출발지의 최단 복귀 거리를 구한다.
     */
    public int[] solution(
            int n,
            int[][] roads,
            int[] sources,
            int destination
    ) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) graph[node] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }
}
