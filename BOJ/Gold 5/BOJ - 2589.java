import java.io.*;
import java.util.*;

class Main {
    /*
     * 모든 육지 칸을 시작점으로 BFS를 수행한다.
     * 각 시작점에서 가장 먼 육지까지의 거리 중 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][];
        for (int row = 0; row < rows; row++) map[row] = br.readLine().toCharArray();

        int answer = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col] == 'L') {
                    answer = Math.max(answer, farthest(row, col, map));
                }
            }
        }

        System.out.print(answer);
    }

    private static int farthest(int startRow, int startCol, char[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int maximum = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            maximum = Math.max(maximum, distance[current[0]][current[1]]);

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == 'W' || distance[nr][nc] != -1) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return maximum;
    }
}
