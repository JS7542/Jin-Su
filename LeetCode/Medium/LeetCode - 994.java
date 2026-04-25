import java.util.*;

class Solution {
    /*
     * 처음 썩은 오렌지를 모두 큐에 넣어 다중 시작점 BFS를 수행한다.
     * 매 분마다 인접한 신선한 오렌지를 썩게 하고 남은 신선한 오렌지 여부를 확인한다.
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) queue.offer(new int[]{row, col});
                else if (grid[row][col] == 1) fresh++;
            }
        }

        int minutes = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];

                    if (nr < 0 || nr >= grid.length
                            || nc < 0 || nc >= grid[0].length
                            || grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
