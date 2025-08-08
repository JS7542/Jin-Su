import java.io.*;
import java.util.*;

class Solution {
    /*
     * 전체 소득 합으로 평균을 계산한다.
     * 평균 이하의 소득을 가진 사람 수를 세어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] income = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;

            for (int i = 0; i < n; i++) {
                income[i] = Integer.parseInt(st.nextToken());
                sum += income[i];
            }

            int answer = 0;

            for (int value : income) {
                if ((long) value * n <= sum) answer++;
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
