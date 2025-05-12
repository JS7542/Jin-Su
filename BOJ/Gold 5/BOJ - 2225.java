import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[count][sum]에 count개의 0 이상 정수로 sum을 만드는 경우의 수를 저장한다.
     * 마지막 수를 0부터 sum까지 모두 시도해 이전 상태를 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final int MOD = 1_000_000_000;

        int[][] dp = new int[k + 1][n + 1];

        for (int sum = 0; sum <= n; sum++) dp[1][sum] = 1;

        for (int count = 2; count <= k; count++) {
            dp[count][0] = 1;

            for (int sum = 1; sum <= n; sum++) {
                dp[count][sum] = (dp[count][sum - 1] + dp[count - 1][sum]) % MOD;
            }
        }

        System.out.print(dp[k][n]);
    }
}
