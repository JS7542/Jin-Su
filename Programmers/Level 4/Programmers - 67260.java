import java.util.*;

class Solution {
    /*
     * 0번 방에서 연결된 방을 탐색하되 선행 방문 조건을 만족하지 못한 방은 대기시킨다.
     * 선행 방을 방문하는 순간 대기 중인 방을 다시 큐에 넣어 모든 방 방문 가능 여부를 확인한다.
     */
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] graph = new ArrayList[n];

        for (int room = 0; room < n; room++) graph[room] = new ArrayList<>();

        for (int[] edge : path) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] required = new int[n];
        Arrays.fill(required, -1);

        for (int[] condition : order) {
            required[condition[1]] = condition[0];
        }

        if (required[0] != -1) return false;

        boolean[] visited = new boolean[n];
        int[] waiting = new int[n];
        Arrays.fill(waiting, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited[current]) continue;

            if (required[current] != -1 && !visited[required[current]]) {
                waiting[required[current]] = current;
                continue;
            }

            visited[current] = true;
            visitedCount++;

            if (waiting[current] != -1) queue.offer(waiting[current]);

            for (int next : graph[current]) {
                if (!visited[next]) queue.offer(next);
            }
        }

        return visitedCount == n;
    }
}
