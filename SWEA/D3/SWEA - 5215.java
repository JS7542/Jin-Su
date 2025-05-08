import java.io.*;
import java.util.*;

class Solution {
    /*
     * 칼로리 한도를 배낭 용량으로 보고 0/1 배낭 DP를 수행한다.
     * 각 재료는 한 번만 사용할 수 있도록 칼로리를 뒤에서부터 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ingredients = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] dp = new int[limit + 1];

            for (int i = 0; i < ingredients; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calories = Integer.parseInt(st.nextToken());

                for (int capacity = limit; capacity >= calories; capacity--) {
                    dp[capacity] = Math.max(
                            dp[capacity],
                            dp[capacity - calories] + score
                    );
                }
            }

            output.append('#').append(tc).append(' ').append(dp[limit]).append('\n');
        }

        System.out.print(output);
    }
}
