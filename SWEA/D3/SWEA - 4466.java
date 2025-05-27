import java.io.*;
import java.util.*;

class Solution {
    /*
     * 과목 점수를 오름차순으로 정렬한다.
     * 가장 높은 K개 점수만 뒤에서부터 더해 최대 총점을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] scores = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) scores[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(scores);
            int answer = 0;

            for (int i = n - 1; i >= n - k; i--) answer += scores[i];

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
