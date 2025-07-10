import java.io.*;
import java.util.*;

class Solution {
    static final long MOD = 1_234_567_891L;

    /*
     * n!과 r!, (n-r)!을 계산한다.
     * 모듈러 역원을 페르마의 소정리로 구해 nCr을 MOD로 나눈 값을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long[] factorial = new long[n + 1];
            factorial[0] = 1;

            for (int value = 1; value <= n; value++) {
                factorial[value] = factorial[value - 1] * value % MOD;
            }

            long denominator = factorial[r] * factorial[n - r] % MOD;
            long answer = factorial[n] * power(denominator, MOD - 2) % MOD;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static long power(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) result = result * base % MOD;

            base = base * base % MOD;
            exponent >>= 1;
        }

        return result;
    }
}
