import java.io.*;

class Main {
    /*
     * 두 문자열의 앞부분끼리 최장 공통 부분수열 길이를 DP로 계산한다.
     * 문자가 같으면 대각선 값에 1을 더하고, 다르면 위와 왼쪽 중 큰 값을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

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

        System.out.print(dp[first.length()][second.length()]);
    }
}
