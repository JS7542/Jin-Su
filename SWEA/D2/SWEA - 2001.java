import java.io.*;
import java.util.*;

class Solution {
    /*
     * M×M 파리채를 놓을 수 있는 모든 왼쪽 위 좌표를 확인한다.
     * 각 영역의 파리 수를 합산하고 그중 최댓값을 정답으로 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int r = 0; r <= n - m; r++) {
                for (int c = 0; c <= n - m; c++) {
                    int sum = 0;
                    for (int i = r; i < r + m; i++) {
                        for (int j = c; j < c + m; j++) sum += map[i][j];
                    }
                    answer = Math.max(answer, sum);
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
