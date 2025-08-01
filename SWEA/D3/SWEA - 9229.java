import java.io.*;
import java.util.*;

class Solution {
    /*
     * 두 과자 봉지의 모든 조합을 확인한다.
     * 무게 합이 제한 M 이하인 값 중 최댓값을 구하고 없으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] snacks = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) snacks[i] = Integer.parseInt(st.nextToken());

            int answer = -1;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = snacks[i] + snacks[j];

                    if (sum <= limit) answer = Math.max(answer, sum);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
