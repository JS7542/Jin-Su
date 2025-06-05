import java.io.*;
import java.util.*;

class Main {
    /*
     * 육지 칸에서 8방향 BFS를 수행해 하나의 섬을 모두 제거한다.
     * 0 0 입력 전까지 각 지도의 섬 개수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            if (width == 0 && height == 0) break;

            int[][] map = new int[height][width];

            for (int r = 0; r < height; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < width; c++) map[r][c] = Integer.parseInt(st.nextToken());
            }

            int islands = 0;

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (map[r][c] == 0) continue;

                    islands++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c});
                    map[r][c] = 0;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int d = 0; d < 8; d++) {
                            int nr = current[0] + dr[d];
                            int nc = current[1] + dc[d];

                            if (nr < 0 || nr >= height || nc < 0 || nc >= width) continue;
                            if (map[nr][nc] == 0) continue;

                            map[nr][nc] = 0;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            output.append(islands).append('\n');
        }

        System.out.print(output);
    }
}
