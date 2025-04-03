import java.io.*;
import java.util.*;

class Solution {
    /*
     * 주변 지뢰가 0개인 칸을 클릭하면 연결된 0칸과 그 주변 칸이 함께 열린다.
     * 0칸 영역을 먼저 BFS로 처리하고 남은 미방문 안전 칸은 각각 한 번 클릭한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[n][];

            for (int row = 0; row < n; row++) map[row] = br.readLine().toCharArray();

            int[][] adjacentMines = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (map[row][col] == '*') continue;

                    for (int d = 0; d < 8; d++) {
                        int nr = row + dr[d];
                        int nc = col + dc[d];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n
                                && map[nr][nc] == '*') {
                            adjacentMines[row][col]++;
                        }
                    }
                }
            }

            boolean[][] visited = new boolean[n][n];
            int clicks = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (map[row][col] == '*' || visited[row][col]
                            || adjacentMines[row][col] != 0) continue;

                    clicks++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int d = 0; d < 8; d++) {
                            int nr = current[0] + dr[d];
                            int nc = current[1] + dc[d];

                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                            if (map[nr][nc] == '*' || visited[nr][nc]) continue;

                            visited[nr][nc] = true;

                            if (adjacentMines[nr][nc] == 0) {
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (map[row][col] != '*' && !visited[row][col]) clicks++;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(clicks).append('\n');
        }

        System.out.print(output);
    }
}
