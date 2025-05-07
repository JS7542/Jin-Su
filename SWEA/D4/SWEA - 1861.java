import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 방에서 현재 값보다 정확히 1 큰 인접 방으로 이동한다.
     * 메모이제이션으로 각 방에서 출발한 최대 이동 길이를 계산한다.
     */
    static int n;
    static int[][] rooms;
    static int[][] memo;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            n = Integer.parseInt(br.readLine());
            rooms = new int[n][n];
            memo = new int[n][n];

            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) rooms[r][c] = Integer.parseInt(st.nextToken());
            }

            int startValue = Integer.MAX_VALUE;
            int maxLength = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int length = dfs(r, c);

                    if (length > maxLength
                            || (length == maxLength && rooms[r][c] < startValue)) {
                        maxLength = length;
                        startValue = rooms[r][c];
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(startValue).append(' ').append(maxLength).append('\n');
        }

        System.out.print(output);
    }

    static int dfs(int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];

        memo[row][col] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (rooms[nr][nc] == rooms[row][col] + 1) {
                memo[row][col] = Math.max(memo[row][col], dfs(nr, nc) + 1);
            }
        }

        return memo[row][col];
    }
}
