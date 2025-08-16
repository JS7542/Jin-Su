import java.io.*;
import java.util.*;

class Main {
    /*
     * 마지막 숫자를 제외한 수들을 순서대로 더하거나 빼는 경우를 DP로 계산한다.
     * 중간 결과가 0부터 20 사이인 상태만 유지하고 마지막 목표값의 경우의 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[21];
        dp[numbers[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            long[] next = new long[21];

            for (int value = 0; value <= 20; value++) {
                if (dp[value] == 0) continue;

                int plus = value + numbers[i];
                int minus = value - numbers[i];

                if (plus <= 20) next[plus] += dp[value];
                if (minus >= 0) next[minus] += dp[value];
            }

            dp = next;
        }

        System.out.print(dp[numbers[n - 1]]);
    }
}
