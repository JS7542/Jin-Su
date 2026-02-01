import java.io.*;
import java.util.*;

class Main {
    /*
     * 배낭 무게별 최대 가치를 1차원 DP로 관리한다.
     * 각 물건을 한 번만 사용하도록 최대 무게에서 물건 무게 방향으로 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int items = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int[] dp = new int[capacity + 1];

        for (int i = 0; i < items; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int current = capacity; current >= weight; current--) {
                dp[current] = Math.max(dp[current], dp[current - weight] + value);
            }
        }

        System.out.print(dp[capacity]);
    }
}
