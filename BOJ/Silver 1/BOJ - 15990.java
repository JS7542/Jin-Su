import java.io.*;

class Main {
    /*
     * 마지막에 사용한 수가 1, 2, 3인 경우를 구분해 DP를 구성한다.
     * 같은 수가 연속되지 않도록 다른 두 마지막 상태에서만 이어 붙인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        int[] queries = new int[tests];
        int max = 0;

        for (int i = 0; i < tests; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, queries[i]);
        }

        final long MOD = 1_000_000_009L;
        long[][] dp = new long[Math.max(4, max + 1)][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int value = 4; value <= max; value++) {
            dp[value][1] = (dp[value - 1][2] + dp[value - 1][3]) % MOD;
            dp[value][2] = (dp[value - 2][1] + dp[value - 2][3]) % MOD;
            dp[value][3] = (dp[value - 3][1] + dp[value - 3][2]) % MOD;
        }

        StringBuilder output = new StringBuilder();

        for (int query : queries) {
            long answer = (dp[query][1] + dp[query][2] + dp[query][3]) % MOD;
            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}
