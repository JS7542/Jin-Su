import java.io.*;
import java.util.*;

class Solution {
    /*
     * A사의 요금은 사용량에 리터당 요금을 곱한다.
     * B사의 기본요금과 초과 사용 요금을 계산해 더 작은 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int companyA = p * w;
            int companyB = q + Math.max(0, w - r) * s;

            output.append('#').append(tc).append(' ')
                    .append(Math.min(companyA, companyB)).append('\n');
        }

        System.out.print(output);
    }
}
