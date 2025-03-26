import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 위치를 마지막 원소로 하는 증가 부분수열의 최대 합을 계산한다.
     * 앞쪽의 더 작은 값에서 이어지는 합 중 최댓값에 현재 값을 더한다.
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
            dp[i] = numbers[i];

            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
