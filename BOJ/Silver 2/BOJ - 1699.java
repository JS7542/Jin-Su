import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[value]에 value를 제곱수 합으로 표현하는 최소 항 개수를 저장한다.
     * value 이하 모든 제곱수를 마지막 항으로 사용하는 경우를 비교한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value = 1; value <= n; value++) {
            for (int root = 1; root * root <= value; root++) {
                dp[value] = Math.min(dp[value], dp[value - root * root] + 1);
            }
        }

        System.out.print(dp[n]);
    }
}
