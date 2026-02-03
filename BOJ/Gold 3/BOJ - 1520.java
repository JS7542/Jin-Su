import java.io.*;
import java.util.*;

class Main {
    static int rows;
    static int cols;
    static int[][] map;
    static int[][] memo;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    /*
     * 현재 칸에서 더 낮은 인접 칸으로만 이동하는 경로 수를 DFS로 계산한다.
     * 각 칸의 결과를 메모이제이션해 같은 부분 문제의 중복 계산을 막는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        map = new int[rows][cols];
        memo = new int[rows][cols];

        for (int[] row : memo) Arrays.fill(row, -1);

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < cols; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(search(0, 0));
    }

    static int search(int row, int col) {
        if (row == rows - 1 && col == cols - 1) return 1;
        if (memo[row][col] != -1) return memo[row][col];

        memo[row][col] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            if (map[nr][nc] < map[row][col]) {
                memo[row][col] += search(nr, nc);
            }
        }

        return memo[row][col];
    }
}
