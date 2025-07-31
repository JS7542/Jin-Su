import java.util.*;

class Solution {
    /*
     * 1번 노드에서 BFS를 수행해 각 노드의 최단 거리를 구한다.
     * 가장 큰 최단 거리와 같은 노드의 개수를 센다.
     */
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) graph[node] = new ArrayList<>();

        for (int[] connection : edge) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        distance[1] = 0;

        int maximum = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                maximum = Math.max(maximum, distance[next]);
                queue.offer(next);
            }
        }

        int answer = 0;

        for (int node = 1; node <= n; node++) {
            if (distance[node] == maximum) answer++;
        }

        return answer;
    }
}
