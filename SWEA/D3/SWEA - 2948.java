import java.io.*;
import java.util.*;

class Solution {
    /*
     * 첫 번째 문자열 집합을 해시셋에 저장한다.
     * 두 번째 집합의 문자열이 해시셋에 존재하는 횟수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Set<String> first = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) first.add(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int common = 0;

            for (int i = 0; i < m; i++) {
                if (first.contains(st.nextToken())) common++;
            }

            output.append('#').append(tc).append(' ').append(common).append('\n');
        }

        System.out.print(output);
    }
}
