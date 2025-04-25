import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 열에서 위쪽으로 끌리는 N극 자석 1을 만난 뒤 S극 자석 2가 나오면 교착이다.
     * 0은 무시하고 1→2 전환 횟수를 모든 열에서 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = test + 1;
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[n][n];

            for (int row = 0; row < n; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    table[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int deadlocks = 0;

            for (int col = 0; col < n; col++) {
                boolean northSeen = false;

                for (int row = 0; row < n; row++) {
                    if (table[row][col] == 1) {
                        northSeen = true;
                    } else if (table[row][col] == 2 && northSeen) {
                        deadlocks++;
                        northSeen = false;
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(deadlocks).append('\n');
        }

        System.out.print(output);
    }
}
