import java.io.*;
import java.util.*;

class Solution {
    /*
     * 중간, 기말, 과제 점수에 가중치를 적용해 각 학생의 총점을 계산한다.
     * K번째 학생보다 높은 총점의 수로 등수를 구하고 구간에 맞는 학점을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            double[] scores = new double[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int task = Integer.parseInt(st.nextToken());
                scores[i] = mid * 0.35 + fin * 0.45 + task * 0.20;
            }

            int rank = 0;
            for (double score : scores) {
                if (score > scores[k - 1]) rank++;
            }

            sb.append('#').append(tc).append(' ')
              .append(grades[rank / (n / 10)]).append('\n');
        }
        System.out.print(sb);
    }
}
