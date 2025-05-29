import java.io.*;
import java.util.*;

class Solution {
    /*
     * 열 개 숫자의 각 자릿수 합을 계산한다.
     * 자릿수 합의 최댓값과 최솟값을 함께 갱신해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;

            for (int i = 0; i < 10; i++) {
                int value = Integer.parseInt(st.nextToken());
                int sum = 0;

                while (value > 0) {
                    sum += value % 10;
                    value /= 10;
                }

                minimum = Math.min(minimum, sum);
                maximum = Math.max(maximum, sum);
            }

            output.append('#').append(tc).append(' ')
                    .append(maximum).append(' ').append(minimum).append('\n');
        }

        System.out.print(output);
    }
}
