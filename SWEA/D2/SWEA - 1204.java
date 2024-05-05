import java.io.*;
import java.util.*;

class Solution {
    /*
     * 0점부터 100점까지의 등장 횟수를 카운팅 배열에 저장한다.
     * 빈도가 같으면 더 큰 점수를 선택하도록 낮은 점수부터 순회한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine().trim());
            int[] count = new int[101];
            int read = 0;

            while (read < 1000) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && read < 1000) {
                    count[Integer.parseInt(st.nextToken())]++;
                    read++;
                }
            }

            int mode = 0;
            for (int score = 0; score <= 100; score++) {
                if (count[score] >= count[mode]) mode = score;
            }

            sb.append('#').append(tc).append(' ').append(mode).append('\n');
        }
        System.out.print(sb);
    }
}
