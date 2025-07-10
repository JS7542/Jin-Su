import java.io.*;
import java.util.*;

class Solution {
    /*
     * 현재 위치에서 끝나는 최대 연속합을 유지한다.
     * 이전 연속합에 현재 값을 더하는 경우와 현재 값부터 새로 시작하는 경우를 비교한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long current = Long.parseLong(st.nextToken());
            long answer = current;

            for (int i = 1; i < n; i++) {
                long value = Long.parseLong(st.nextToken());

                current = Math.max(value, current + value);
                answer = Math.max(answer, current);
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
