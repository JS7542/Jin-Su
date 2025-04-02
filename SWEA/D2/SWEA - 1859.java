import java.io.*;
import java.util.*;

class Solution {
    /*
     * 뒤에서부터 현재 이후의 최고 판매가를 유지한다.
     * 현재 가격이 최고가보다 낮으면 차익을 더하고, 높으면 새로운 최고가로 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int days = Integer.parseInt(br.readLine());
            int[] prices = new int[days];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < days; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maximum = 0;
            long profit = 0;

            for (int day = days - 1; day >= 0; day--) {
                maximum = Math.max(maximum, prices[day]);
                profit += maximum - prices[day];
            }

            output.append('#').append(tc).append(' ')
                    .append(profit).append('\n');
        }

        System.out.print(output);
    }
}
