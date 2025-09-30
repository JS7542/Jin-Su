import java.io.*;
import java.util.*;

class Main {
    /*
     * 처음 익은 모든 토마토를 큐에 넣어 다중 시작점 BFS를 수행한다.
     * 마지막으로 익은 날짜를 구하고 익지 않은 토마토가 남으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] box = new int[height][width];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < height; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < width; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if (box[r][c] == 1) queue.offer(new int[]{r, c});
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= height || nc < 0 || nc >= width) continue;
                if (box[nr][nc] != 0) continue;

                box[nr][nc] = box[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        int max = 1;

        for (int[] row : box) {
            for (int value : row) {
                if (value == 0) {
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, value);
            }
        }

        System.out.print(max - 1);
    }
}
