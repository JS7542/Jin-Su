import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[count]에 카드 count개를 구매하는 최대 금액을 저장한다.
     * 마지막에 구매할 카드 묶음 크기를 모두 시도해 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] price = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) price[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        for (int count = 1; count <= n; count++) {
            for (int pack = 1; pack <= count; pack++) {
                dp[count] = Math.max(dp[count], dp[count - pack] + price[pack]);
            }
        }

        System.out.print(dp[n]);
    }
}
