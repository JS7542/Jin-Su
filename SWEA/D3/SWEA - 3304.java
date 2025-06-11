import java.io.*;
import java.util.*;

class Solution {
    /*
     * 두 문자열의 앞부분끼리 최장 공통 부분수열 길이를 DP로 계산한다.
     * 문자가 같으면 대각선 값에 1을 더하고 다르면 위와 왼쪽 중 큰 값을 사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            int[][] dp = new int[first.length() + 1][second.length() + 1];

            for (int i = 1; i <= first.length(); i++) {
                for (int j = 1; j <= second.length(); j++) {
                    if (first.charAt(i - 1) == second.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(dp[first.length()][second.length()]).append('\n');
        }

        System.out.print(output);
    }
}
