import java.io.*;

class Main {
    /*
     * 홀수 너비는 채울 수 없고, 짝수 너비만 DP로 계산한다.
     * 기본 3가지 배치와 이전 모든 짝수 구간의 특수 배치 2가지를 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int width = 2; width <= n; width += 2) {
            dp[width] = dp[width - 2] * 3;

            for (int previous = width - 4; previous >= 0; previous -= 2) {
                dp[width] += dp[previous] * 2;
            }
        }

        System.out.print(dp[n]);
    }
}
