import java.io.*;
import java.util.*;

class Main {
    /*
     * 연속한 파일 구간을 합치는 최소 비용을 구간 DP로 계산한다.
     * 분할 위치별 두 부분 비용과 전체 구간 파일 크기 합을 더해 최솟값을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] files = new int[n + 1];
            int[] prefix = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + files[i];
            }

            int[][] dp = new int[n + 1][n + 1];

            for (int length = 2; length <= n; length++) {
                for (int start = 1; start + length - 1 <= n; start++) {
                    int end = start + length - 1;
                    dp[start][end] = Integer.MAX_VALUE;
                    int sum = prefix[end] - prefix[start - 1];

                    for (int split = start; split < end; split++) {
                        dp[start][end] = Math.min(
                                dp[start][end],
                                dp[start][split] + dp[split + 1][end] + sum
                        );
                    }
                }
            }

            output.append(dp[1][n]).append('\n');
        }

        System.out.print(output);
    }
}
