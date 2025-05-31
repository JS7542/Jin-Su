import java.io.*;
import java.util.*;

class Solution {
    /*
     * 18번 중 완제품 개수가 소수가 아닐 확률을 두 회사에 대해 각각 계산한다.
     * 둘 다 소수가 아닌 경우를 1에서 빼 최소 한 회사가 소수 개수인 확률을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        boolean[] prime = new boolean[19];

        for (int value : new int[]{2, 3, 5, 7, 11, 13, 17}) prime[value] = true;

        long[][] combination = new long[19][19];

        for (int n = 0; n <= 18; n++) {
            combination[n][0] = combination[n][n] = 1;

            for (int r = 1; r < n; r++) {
                combination[n][r] = combination[n - 1][r - 1]
                        + combination[n - 1][r];
            }
        }

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double firstProbability = Integer.parseInt(st.nextToken()) / 100.0;
            double secondProbability = Integer.parseInt(st.nextToken()) / 100.0;

            double firstNonPrime = 0.0;
            double secondNonPrime = 0.0;

            for (int completed = 0; completed <= 18; completed++) {
                if (prime[completed]) continue;

                firstNonPrime += combination[18][completed]
                        * Math.pow(firstProbability, completed)
                        * Math.pow(1.0 - firstProbability, 18 - completed);

                secondNonPrime += combination[18][completed]
                        * Math.pow(secondProbability, completed)
                        * Math.pow(1.0 - secondProbability, 18 - completed);
            }

            double answer = 1.0 - firstNonPrime * secondNonPrime;

            output.append('#').append(tc).append(' ')
                    .append(String.format(Locale.US, "%.6f", answer))
                    .append('\n');
        }

        System.out.print(output);
    }
}
