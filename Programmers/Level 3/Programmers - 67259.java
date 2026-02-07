import java.util.*;

class Solution {
    /*
     * 위치와 직전 이동 방향을 상태로 두고 다익스트라 탐색을 수행한다.
     * 같은 방향 이동은 100원, 방향 전환 이동은 600원을 추가한다.
     */
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int[][] row : cost) {
            for (int[] cell : row) Arrays.fill(cell, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state[3])
        );

        for (int direction = 0; direction < 4; direction++) {
            cost[0][0][direction] = 0;
            queue.offer(new int[]{0, 0, direction, 0});
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int direction = current[2];
            int currentCost = current[3];

            if (currentCost != cost[row][col][direction]) continue;

            for (int nextDirection = 0; nextDirection < 4; nextDirection++) {
                int nr = row + dr[nextDirection];
                int nc = col + dc[nextDirection];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n
                        || board[nr][nc] == 1) continue;

                int nextCost = currentCost
                        + (direction == nextDirection ? 100 : 600);

                if (nextCost < cost[nr][nc][nextDirection]) {
                    cost[nr][nc][nextDirection] = nextCost;
                    queue.offer(new int[]{nr, nc, nextDirection, nextCost});
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int direction = 0; direction < 4; direction++) {
            answer = Math.min(answer, cost[n - 1][n - 1][direction]);
        }

        return answer;
    }
}
