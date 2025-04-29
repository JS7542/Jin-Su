import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 문자를 내부 구멍 개수 0, 1, 2로 변환한다.
     * 두 문자열의 길이와 각 위치의 구멍 개수가 모두 같은지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            boolean same = first.length() == second.length();

            for (int i = 0; i < first.length() && same; i++) {
                if (holes(first.charAt(i)) != holes(second.charAt(i))) same = false;
            }

            output.append('#').append(tc).append(' ')
                    .append(same ? "SAME" : "DIFF").append('\n');
        }

        System.out.print(output);
    }

    private static int holes(char ch) {
        if (ch == 'B') return 2;
        if ("ADOPQR".indexOf(ch) >= 0) return 1;
        return 0;
    }
}
