import java.io.*;
import java.util.*;

class Solution {
    /*
     * 길이가 짧은 수열을 긴 수열 위에서 한 칸씩 이동시키며 곱의 합을 계산한다.
     * 모든 정렬 위치의 합 중 가장 큰 값을 정답으로 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

            int[] small = n <= m ? a : b;
            int[] large = n <= m ? b : a;
            int answer = Integer.MIN_VALUE;

            for (int offset = 0; offset <= large.length - small.length; offset++) {
                int sum = 0;
                for (int i = 0; i < small.length; i++) {
                    sum += small[i] * large[offset + i];
                }
                answer = Math.max(answer, sum);
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
