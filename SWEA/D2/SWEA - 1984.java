import java.io.*;
import java.util.*;

class Solution {
    /*
     * 열 개의 수 중 최댓값과 최솟값을 제외한 나머지 합을 구한다.
     * 나머지 여덟 수의 평균을 계산하고 Math.round로 반올림한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 10; i++) {
                int value = Integer.parseInt(st.nextToken());
                sum += value;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            int answer = (int) Math.round((sum - min - max) / 8.0);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
