import java.util.*;

class Solution {
    /*
     * 전선 하나를 끊은 상태에서 한쪽 송전탑 개수를 BFS로 센다.
     * 두 전력망 크기 차이의 최솟값을 모든 전선에 대해 비교한다.
     */
    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int removed = 0; removed < wires.length; removed++) {
            List<Integer>[] graph = new ArrayList[n + 1];

            for (int node = 1; node <= n; node++) {
                graph[node] = new ArrayList<>();
            }

            for (int index = 0; index < wires.length; index++) {
                if (index == removed) continue;

                int first = wires[index][0];
                int second = wires[index][1];

                graph[first].add(second);
                graph[second].add(first);
            }

            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(1);
            visited[1] = true;
            int count = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                count++;

                for (int next : graph[current]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            answer = Math.min(answer, Math.abs(n - count * 2));
        }

        return answer;
    }
}
