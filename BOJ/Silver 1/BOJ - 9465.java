import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 열에서 위 스티커를 고른 경우와 아래 스티커를 고른 경우의 최댓값을 계산한다.
     * 같은 열과 인접 열의 같은 행을 고를 수 없도록 이전 두 열 상태를 참고한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];

            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= n; col++) {
                    sticker[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];

            if (n >= 1) {
                dp[0][1] = sticker[0][1];
                dp[1][1] = sticker[1][1];
            }

            for (int col = 2; col <= n; col++) {
                dp[0][col] = sticker[0][col]
                        + Math.max(dp[1][col - 1], col >= 2 ? dp[1][col - 2] : 0);
                dp[1][col] = sticker[1][col]
                        + Math.max(dp[0][col - 1], col >= 2 ? dp[0][col - 2] : 0);
            }

            output.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }

        System.out.print(output);
    }
}
