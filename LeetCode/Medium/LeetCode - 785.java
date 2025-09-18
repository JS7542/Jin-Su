import java.util.*;

class Solution {
    /*
     * 방문하지 않은 정점에서 BFS를 시작해 인접 정점에 반대 색을 부여한다.
     * 연결된 두 정점의 색이 같아지는 경우가 있으면 이분 그래프가 아니다.
     */
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int start = 0; start < graph.length; start++) {
            if (color[start] != 0) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            color[start] = 1;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (color[next] == 0) {
                        color[next] = -color[current];
                        queue.offer(next);
                    } else if (color[next] == color[current]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
