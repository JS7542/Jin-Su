import java.io.*;
import java.util.*;

class Solution {
    /*
     * 가방 부피별 최대 가치를 1차원 DP로 저장한다.
     * 각 물건을 한 번만 사용하도록 큰 부피에서 작은 부피 방향으로 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int items = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            int[] dp = new int[capacity + 1];

            for (int item = 0; item < items; item++) {
                st = new StringTokenizer(br.readLine());
                int volume = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                for (int current = capacity; current >= volume; current--) {
                    dp[current] = Math.max(
                            dp[current],
                            dp[current - volume] + value
                    );
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(dp[capacity]).append('\n');
        }

        System.out.print(output);
    }
}
