import java.io.*;

class Main {
    /*
     * n을 만드는 마지막 수가 1, 2, 3인 경우를 각각 이전 상태에서 이어 붙인다.
     * 여러 테스트를 위해 최대 입력까지 미리 DP를 계산한다.
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
        long[] dp = new long[Math.max(4, max + 1)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int value = 4; value <= max; value++) {
            dp[value] = (dp[value - 1] + dp[value - 2] + dp[value - 3]) % MOD;
        }

        StringBuilder output = new StringBuilder();

        for (int query : queries) output.append(dp[query]).append('\n');

        System.out.print(output);
    }
}
