import java.io.*;
import java.util.*;

class Solution {
    /*
     * M의 마지막 N개 비트가 모두 1인지 비트 마스크로 확인한다.
     * (1<<N)-1과 M의 AND 결과가 마스크와 같으면 ON이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int mask = (1 << n) - 1;
            String result = (m & mask) == mask ? "ON" : "OFF";

            output.append('#').append(tc).append(' ')
                    .append(result).append('\n');
        }

        System.out.print(output);
    }
}
