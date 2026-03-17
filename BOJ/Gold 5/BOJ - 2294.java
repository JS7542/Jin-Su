import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[value]에 value를 만드는 최소 동전 수를 저장한다.
     * 각 금액에서 모든 동전을 확인하고 이전 금액의 최솟값에 1을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;

        for (int value = 1; value <= target; value++) {
            for (int coin : coins) {
                if (coin <= value) {
                    dp[value] = Math.min(dp[value], dp[value - coin] + 1);
                }
            }
        }

        System.out.print(dp[target] > target ? -1 : dp[target]);
    }
}
