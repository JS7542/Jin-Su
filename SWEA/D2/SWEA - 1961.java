import java.io.*;
import java.util.*;

class Solution {
    /*
     * 원본 배열의 좌표를 변환해 90도, 180도, 270도 회전 결과를 구한다.
     * 각 회전 결과의 같은 행을 문제에서 요구한 순서대로 나란히 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append('#').append(tc).append('\n');
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) sb.append(map[n - 1 - j][i]);
                sb.append(' ');
                for (int j = 0; j < n; j++) sb.append(map[n - 1 - i][n - 1 - j]);
                sb.append(' ');
                for (int j = 0; j < n; j++) sb.append(map[j][n - 1 - i]);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
