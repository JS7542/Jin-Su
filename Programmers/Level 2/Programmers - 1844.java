import java.util.*;

class Solution {
    /*
     * 시작 칸에서 상하좌우로 이동하는 BFS를 수행한다.
     * 방문 칸에 시작점부터의 거리를 기록해 도착점의 최단 거리를 반환한다.
     */
    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        int[][] distance = new int[rows][cols];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (maps[nr][nc] == 0 || distance[nr][nc] != 0) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return distance[rows - 1][cols - 1] == 0
                ? -1
                : distance[rows - 1][cols - 1];
    }
}
