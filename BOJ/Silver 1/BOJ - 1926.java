import java.io.*;
import java.util.*;

class Main {
    /*
     * 값이 1인 미방문 칸에서 BFS를 시작한다.
     * 그림 개수와 각 그림 넓이의 최댓값을 함께 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) board[r][c] = Integer.parseInt(st.nextToken());
        }

        int pictures = 0;
        int largest = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 0) continue;

                pictures++;
                int area = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{r, c});
                board[r][c] = 0;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    area++;

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (board[nr][nc] == 0) continue;

                        board[nr][nc] = 0;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                largest = Math.max(largest, area);
            }
        }

        System.out.println(pictures);
        System.out.print(largest);
    }
}
