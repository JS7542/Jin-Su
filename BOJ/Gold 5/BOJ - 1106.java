import java.io.*;
import java.util.*;

class Main {
    /*
     * 고객 수별 최소 홍보 비용을 무한 배낭 DP로 계산한다.
     * 목표 고객 수를 넘겨도 되므로 최대 증가량만큼 배열 범위를 확장한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        int cities = Integer.parseInt(st.nextToken());

        int[] cost = new int[cities];
        int[] customers = new int[cities];
        int maxCustomers = 0;

        for (int i = 0; i < cities; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customers[i] = Integer.parseInt(st.nextToken());
            maxCustomers = Math.max(maxCustomers, customers[i]);
        }

        int limit = target + maxCustomers;
        int[] dp = new int[limit + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 4);
        dp[0] = 0;

        for (int current = 1; current <= limit; current++) {
            for (int city = 0; city < cities; city++) {
                if (current >= customers[city]) {
                    dp[current] = Math.min(
                            dp[current],
                            dp[current - customers[city]] + cost[city]
                    );
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int customer = target; customer <= limit; customer++) {
            answer = Math.min(answer, dp[customer]);
        }

        System.out.print(answer);
    }
}
