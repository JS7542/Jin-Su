import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 달까지의 최소 이용권 비용을 DP로 계산한다.
     * 하루권·한 달권·세 달권을 사용하는 경우를 비교하고 마지막에 1년권과 비교한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int threeMonths = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int[] plans = new int[13];
            st = new StringTokenizer(br.readLine());

            for (int currentMonth = 1; currentMonth <= 12; currentMonth++) {
                plans[currentMonth] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];

            for (int currentMonth = 1; currentMonth <= 12; currentMonth++) {
                int oneMonthCost = Math.min(
                        plans[currentMonth] * day,
                        month
                );

                dp[currentMonth] = dp[currentMonth - 1] + oneMonthCost;

                if (currentMonth >= 3) {
                    dp[currentMonth] = Math.min(
                            dp[currentMonth],
                            dp[currentMonth - 3] + threeMonths
                    );
                } else {
                    dp[currentMonth] = Math.min(dp[currentMonth], threeMonths);
                }
            }

            int answer = Math.min(dp[12], year);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
