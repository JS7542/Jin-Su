import java.io.*;
import java.util.*;

class Solution {
    /*
     * 카드 덱을 앞 절반과 뒤 절반으로 나눈다.
     * 앞 절반 카드부터 두 구간을 번갈아 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] cards = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) cards[i] = st.nextToken();

            int secondStart = (n + 1) / 2;

            output.append('#').append(tc).append(' ');

            for (int i = 0; i < secondStart; i++) {
                output.append(cards[i]).append(' ');

                int secondIndex = secondStart + i;
                if (secondIndex < n) output.append(cards[secondIndex]).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
