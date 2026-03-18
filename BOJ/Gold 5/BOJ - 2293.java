import java.io.*;
import java.util.*;

class Main {
    /*
     * dp[value]에 주어진 동전들로 value를 만드는 경우의 수를 저장한다.
     * 동전을 바깥 반복으로 두어 순서가 다른 같은 조합을 중복해서 세지 않는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int value = coin; value <= target; value++) {
                dp[value] += dp[value - coin];
            }
        }

        System.out.print(dp[target]);
    }
}
