import java.io.*;
import java.util.*;

class Solution {
    /*
     * possible[score]에 현재까지 만들 수 있는 점수인지 저장한다.
     * 각 문제 점수를 한 번만 더하도록 높은 점수에서 낮은 점수 방향으로 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] scores = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = 0;

            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                total += scores[i];
            }

            boolean[] possible = new boolean[total + 1];
            possible[0] = true;

            int currentTotal = 0;

            for (int score : scores) {
                for (int value = currentTotal; value >= 0; value--) {
                    if (possible[value]) possible[value + score] = true;
                }

                currentTotal += score;
            }

            int count = 0;

            for (boolean value : possible) {
                if (value) count++;
            }

            output.append('#').append(tc).append(' ')
                    .append(count).append('\n');
        }

        System.out.print(output);
    }
}
