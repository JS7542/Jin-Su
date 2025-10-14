import java.io.*;

class Main {
    /*
     * 길이별 마지막 숫자에 따른 계단 수 개수를 DP로 관리한다.
     * 현재 숫자는 이전 길이의 인접 숫자에서만 이어질 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;

        int[] dp = new int[10];
        for (int digit = 1; digit <= 9; digit++) dp[digit] = 1;

        for (int length = 2; length <= n; length++) {
            int[] next = new int[10];

            next[0] = dp[1];
            next[9] = dp[8];

            for (int digit = 1; digit <= 8; digit++) {
                next[digit] = (dp[digit - 1] + dp[digit + 1]) % MOD;
            }

            dp = next;
        }

        long answer = 0;
        for (int count : dp) answer = (answer + count) % MOD;

        System.out.print(answer);
    }
}
