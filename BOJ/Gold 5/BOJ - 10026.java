import java.io.*;
import java.util.*;

class Main {
    /*
     * 일반 시야와 적록색약 시야의 연결 영역 수를 각각 BFS로 센다.
     * 적록색약에서는 R과 G를 같은 색으로 비교한다.
     */
    static int n;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][];

        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        System.out.print(count(false) + " " + count(true));
    }

    static int count(boolean weak) {
        boolean[][] visited = new boolean[n][n];
        int regions = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c]) continue;

                regions++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{r, c});
                visited[r][c] = true;
                char color = board[r][c];

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (visited[nr][nc] || !same(color, board[nr][nc], weak)) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return regions;
    }

    static boolean same(char a, char b, boolean weak) {
        if (!weak) return a == b;
        if (a == 'B' || b == 'B') return a == b;
        return true;
    }
}
