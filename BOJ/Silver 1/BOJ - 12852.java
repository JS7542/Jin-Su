import java.io.*;
import java.util.*;

class Main {
    /*
     * 1부터 N까지 최소 연산 횟수와 이전 숫자를 DP로 저장한다.
     * N에서 이전 숫자를 따라가며 최소 연산 경로를 복원한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] previous = new int[n + 1];

        for (int value = 2; value <= n; value++) {
            dp[value] = dp[value - 1] + 1;
            previous[value] = value - 1;

            if (value % 2 == 0 && dp[value / 2] + 1 < dp[value]) {
                dp[value] = dp[value / 2] + 1;
                previous[value] = value / 2;
            }

            if (value % 3 == 0 && dp[value / 3] + 1 < dp[value]) {
                dp[value] = dp[value / 3] + 1;
                previous[value] = value / 3;
            }
        }

        StringBuilder path = new StringBuilder();
        int current = n;

        while (current > 0) {
            path.append(current).append(' ');
            if (current == 1) break;
            current = previous[current];
        }

        System.out.println(dp[n]);
        System.out.print(path);
    }
}
