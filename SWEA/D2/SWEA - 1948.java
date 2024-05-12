import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 날짜를 해당 연도의 누적 일수로 변환한다.
     * 두 번째 날짜의 누적 일수에서 첫 번째 날짜를 빼고 1을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            int start = d1;
            int end = d2;
            for (int m = 1; m < m1; m++) start += days[m];
            for (int m = 1; m < m2; m++) end += days[m];

            sb.append('#').append(tc).append(' ').append(end - start + 1).append('\n');
        }
        System.out.print(sb);
    }
}
