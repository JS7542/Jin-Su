import java.io.*;

class Main {
    /*
     * dp[digit]에 현재 길이에서 digit으로 끝나는 오르막 수 개수를 저장한다.
     * 다음 길이에서는 0부터 현재 digit까지의 누적합으로 값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 10007;

        int[] dp = new int[10];
        for (int digit = 0; digit < 10; digit++) dp[digit] = 1;

        for (int length = 2; length <= n; length++) {
            for (int digit = 1; digit < 10; digit++) {
                dp[digit] = (dp[digit] + dp[digit - 1]) % MOD;
            }
        }

        int answer = 0;
        for (int count : dp) answer = (answer + count) % MOD;

        System.out.print(answer);
    }
}
