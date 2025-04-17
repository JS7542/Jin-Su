import java.io.*;
import java.util.*;

class Main {
    /*
     * 가능한 강수 높이를 모두 시도한다.
     * 물에 잠기지 않은 칸들의 연결 요소 수를 BFS로 세어 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] height = new int[n][n];
        int maxHeight = 0;

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 0; c < n; c++) {
                height[r][c] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height[r][c]);
            }
        }

        int answer = 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int rain = 1; rain < maxHeight; rain++) {
            boolean[][] visited = new boolean[n][n];
            int areas = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (height[r][c] <= rain || visited[r][c]) continue;

                    areas++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = current[0] + dr[d];
                            int nc = current[1] + dc[d];

                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                            if (height[nr][nc] <= rain || visited[nr][nc]) continue;

                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            answer = Math.max(answer, areas);
        }

        System.out.print(answer);
    }
}
