import java.util.*;

class Solution {
    /*
     * 로봇이 장애물이나 경계 직전까지 미끄러진 위치를 다음 BFS 상태로 사용한다.
     * 목표 지점에 처음 도달한 이동 횟수가 최소 명령 수다.
     */
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows; row++) {
            int col = board[row].indexOf('R');

            if (col >= 0) {
                startRow = row;
                startCol = col;
                break;
            }
        }

        int[][] distance = new int[rows][cols];

        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (board[current[0]].charAt(current[1]) == 'G') {
                return distance[current[0]][current[1]];
            }

            for (int direction = 0; direction < 4; direction++) {
                int row = current[0];
                int col = current[1];

                while (true) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols
                            || board[nr].charAt(nc) == 'D') break;

                    row = nr;
                    col = nc;
                }

                if (distance[row][col] != -1) continue;

                distance[row][col] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }

        return -1;
    }
}
