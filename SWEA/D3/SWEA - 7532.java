import java.io.*;
import java.util.*;

class Solution {
    /*
     * S 조건을 만족하는 해를 365씩 증가시키며 확인한다.
     * E와 M 나머지 조건까지 만족하는 첫 연도를 찾는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int year = s;

            while ((year - e) % 24 != 0 || (year - m) % 29 != 0) {
                year += 365;
            }

            output.append('#').append(tc).append(' ')
                    .append(year).append('\n');
        }

        System.out.print(output);
    }
}
