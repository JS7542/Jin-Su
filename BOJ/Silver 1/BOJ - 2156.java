import java.io.*;

class Main {
    /*
     * 연속 세 잔을 마실 수 없다는 조건으로 각 위치까지의 최대 양을 계산한다.
     * 현재 잔을 건너뛰기, 현재만 마시기, 이전 잔과 함께 마시기를 비교한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) wine[i] = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.print(wine[1]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(
                            dp[i - 2] + wine[i],
                            dp[i - 3] + wine[i - 1] + wine[i]
                    )
            );
        }

        System.out.print(dp[n]);
    }
}
