import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 행과 열, 3×3 영역에서 숫자 중복이 발생하는지 검사한다.
     * 세 조건을 모두 만족하면 1, 하나라도 중복이 있으면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            boolean valid = true;

            for (int i = 0; i < 9 && valid; i++) {
                boolean[] row = new boolean[10];
                boolean[] col = new boolean[10];

                for (int j = 0; j < 9; j++) {
                    if (row[map[i][j]] || col[map[j][i]]) {
                        valid = false;
                        break;
                    }
                    row[map[i][j]] = true;
                    col[map[j][i]] = true;
                }
            }

            for (int sr = 0; sr < 9 && valid; sr += 3) {
                for (int sc = 0; sc < 9 && valid; sc += 3) {
                    boolean[] used = new boolean[10];
                    for (int r = sr; r < sr + 3; r++) {
                        for (int c = sc; c < sc + 3; c++) {
                            if (used[map[r][c]]) valid = false;
                            used[map[r][c]] = true;
                        }
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(valid ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }
}
