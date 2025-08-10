import java.io.*;
import java.util.*;

class Solution {
    /*
     * 직원 순서대로 아직 맡지 않은 일을 하나씩 선택한다.
     * 현재 확률이 이미 구한 최댓값 이하이면 더 진행하지 않아 탐색을 줄인다.
     */
    static int n;
    static double[][] probability;
    static boolean[] assigned;
    static double answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            n = Integer.parseInt(br.readLine());
            probability = new double[n][n];
            assigned = new boolean[n];

            for (int person = 0; person < n; person++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int job = 0; job < n; job++) {
                    probability[person][job] = Integer.parseInt(st.nextToken()) / 100.0;
                }
            }

            answer = 0.0;
            search(0, 1.0);

            output.append('#').append(tc).append(' ')
                    .append(String.format(Locale.US, "%.6f", answer * 100))
                    .append('\n');
        }

        System.out.print(output);
    }

    static void search(int person, double current) {
        if (current <= answer) return;

        if (person == n) {
            answer = current;
            return;
        }

        for (int job = 0; job < n; job++) {
            if (assigned[job] || probability[person][job] == 0) continue;

            assigned[job] = true;
            search(person + 1, current * probability[person][job]);
            assigned[job] = false;
        }
    }
}
