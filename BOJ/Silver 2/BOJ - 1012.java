import java.io.*;
import java.util.*;

class Main {
    /*
     * 배추가 있고 방문하지 않은 칸마다 BFS를 시작한다.
     * 연결된 배추 묶음의 개수가 필요한 지렁이 수다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (tests-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            boolean[][] field = new boolean[height][width];

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = true;
            }

            int worms = 0;

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (!field[r][c]) continue;

                    worms++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c});
                    field[r][c] = false;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = current[0] + dr[d];
                            int nc = current[1] + dc[d];

                            if (nr < 0 || nr >= height || nc < 0 || nc >= width) continue;
                            if (!field[nr][nc]) continue;

                            field[nr][nc] = false;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            output.append(worms).append('\n');
        }

        System.out.print(output);
    }
}
