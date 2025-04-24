import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 날짜에서 상담을 하지 않는 경우와 상담을 완료하는 경우를 DP로 전파한다.
     * 퇴사일까지 얻을 수 있는 최대 수익을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] profit = new int[n + 1];

        for (int day = 1; day <= n; day++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[day] = Integer.parseInt(st.nextToken());
            profit[day] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];

        for (int day = 1; day <= n; day++) {
            dp[day] = Math.max(dp[day], dp[day - 1]);

            int finish = day + time[day];

            if (finish <= n + 1) {
                dp[finish] = Math.max(dp[finish], dp[day] + profit[day]);
            }
        }

        System.out.print(Math.max(dp[n], dp[n + 1]));
    }
}
