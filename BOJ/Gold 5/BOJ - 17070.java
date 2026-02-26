import java.io.*;
import java.util.*;

class Main {
    /*
     * 파이프 끝 위치와 방향별 도달 방법 수를 DP로 저장한다.
     * 가로·세로·대각선 방향에서 가능한 다음 방향으로 상태를 전이한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] house = new int[size][size];

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                house[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[size][size][3];
        dp[0][1][0] = 1;

        for (int row = 0; row < size; row++) {
            for (int col = 1; col < size; col++) {
                if (house[row][col] == 1) continue;

                if (col + 1 < size && house[row][col + 1] == 0) {
                    dp[row][col + 1][0] += dp[row][col][0] + dp[row][col][2];
                }

                if (row + 1 < size && house[row + 1][col] == 0) {
                    dp[row + 1][col][1] += dp[row][col][1] + dp[row][col][2];
                }

                if (row + 1 < size && col + 1 < size
                        && house[row][col + 1] == 0
                        && house[row + 1][col] == 0
                        && house[row + 1][col + 1] == 0) {
                    dp[row + 1][col + 1][2] += dp[row][col][0]
                            + dp[row][col][1]
                            + dp[row][col][2];
                }
            }
        }

        long answer = dp[size - 1][size - 1][0]
                + dp[size - 1][size - 1][1]
                + dp[size - 1][size - 1][2];

        System.out.print(answer);
    }
}
