import java.io.*;

class Solution {
    /*
     * 오른쪽, 아래, 왼쪽, 위 순서로 배열을 이동하며 1부터 N²까지 채운다.
     * 범위를 벗어나거나 이미 채운 칸을 만나면 다음 방향으로 회전한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[n][n];
            int r = 0, c = 0, dir = 0;

            for (int num = 1; num <= n * n; num++) {
                map[r][c] = num;
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 0) {
                    dir = (dir + 1) % 4;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }

                r = nr;
                c = nc;
            }

            sb.append('#').append(tc).append('\n');
            for (int[] row : map) {
                for (int value : row) sb.append(value).append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
