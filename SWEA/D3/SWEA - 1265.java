import java.io.*;
import java.util.*;

class Solution {
    /*
     * 합이 N인 P개의 양의 정수 곱은 값들이 최대한 균등할 때 가장 크다.
     * 몫과 나머지에 따라 quotient와 quotient+1을 필요한 개수만큼 곱한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int parts = Integer.parseInt(st.nextToken());

            long quotient = n / parts;
            int remainder = (int) (n % parts);
            long answer = 1;

            for (int index = 0; index < parts; index++) {
                answer *= index < remainder ? quotient + 1 : quotient;
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
