import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[start][end]에 start부터 end 행렬을 곱하는 최소 연산 수를 저장한다.
     * 모든 분할 위치를 시도해 왼쪽·오른쪽 비용과 마지막 곱셈 비용을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] rows = new int[n];
        int[] cols = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rows[i] = Integer.parseInt(st.nextToken());
            cols[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][n];

        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;
                dp[start][end] = Long.MAX_VALUE;

                for (int split = start; split < end; split++) {
                    long cost = dp[start][split]
                            + dp[split + 1][end]
                            + (long) rows[start] * cols[split] * cols[end];

                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        System.out.print(dp[0][n - 1]);
    }
}
