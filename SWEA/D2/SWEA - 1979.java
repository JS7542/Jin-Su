import java.io.*;
import java.util.*;

class Solution {
    /*
     * 가로와 세로에서 연속된 1의 길이를 각각 센다.
     * 0이나 배열의 끝을 만났을 때 연속 길이가 정확히 K이면 정답을 증가시킨다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                int rowCount = 0;
                int colCount = 0;

                for (int j = 0; j <= n; j++) {
                    if (j < n && map[i][j] == 1) rowCount++;
                    else {
                        if (rowCount == k) answer++;
                        rowCount = 0;
                    }

                    if (j < n && map[j][i] == 1) colCount++;
                    else {
                        if (colCount == k) answer++;
                        colCount = 0;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
