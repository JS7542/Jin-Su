import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 위치를 마지막 원소로 하는 감소 부분수열 길이를 계산한다.
     * 앞쪽의 더 큰 값에서 이어지는 길이 중 최댓값에 1을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
