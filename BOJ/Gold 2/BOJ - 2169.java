import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 행에서 왼쪽→오른쪽, 오른쪽→왼쪽 누적 최댓값을 각각 계산한다.
     * 두 방향 결과의 최댓값을 다음 행의 DP로 사용해 좌우 이동을 모두 반영한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] map = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < cols; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[cols];
        dp[0] = map[0][0];

        for (int c = 1; c < cols; c++) {
            dp[c] = dp[c - 1] + map[0][c];
        }

        for (int r = 1; r < rows; r++) {
            int[] left = new int[cols];
            int[] right = new int[cols];

            left[0] = dp[0] + map[r][0];

            for (int c = 1; c < cols; c++) {
                left[c] = Math.max(dp[c], left[c - 1]) + map[r][c];
            }

            right[cols - 1] = dp[cols - 1] + map[r][cols - 1];

            for (int c = cols - 2; c >= 0; c--) {
                right[c] = Math.max(dp[c], right[c + 1]) + map[r][c];
            }

            for (int c = 0; c < cols; c++) {
                dp[c] = Math.max(left[c], right[c]);
            }
        }

        System.out.print(dp[cols - 1]);
    }
}
