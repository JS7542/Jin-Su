import java.io.*;
import java.util.*;

class Main {
    /*
     * 처음 익은 모든 토마토를 큐에 넣어 3차원 다중 시작점 BFS를 수행한다.
     * 마지막으로 익은 날짜를 기록하고 익지 않은 토마토가 남으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());
        int heights = Integer.parseInt(st.nextToken());

        int[][][] box = new int[heights][rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        int unripe = 0;

        for (int height = 0; height < heights; height++) {
            for (int row = 0; row < rows; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < cols; col++) {
                    box[height][row][col] = Integer.parseInt(st.nextToken());

                    if (box[height][row][col] == 1) {
                        queue.offer(new int[]{height, row, col});
                    } else if (box[height][row][col] == 0) {
                        unripe++;
                    }
                }
            }
        }

        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, 0, -1, 1};
        int days = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 6; direction++) {
                int nh = current[0] + dh[direction];
                int nr = current[1] + dr[direction];
                int nc = current[2] + dc[direction];

                if (nh < 0 || nh >= heights
                        || nr < 0 || nr >= rows
                        || nc < 0 || nc >= cols
                        || box[nh][nr][nc] != 0) continue;

                box[nh][nr][nc] = box[current[0]][current[1]][current[2]] + 1;
                days = Math.max(days, box[nh][nr][nc] - 1);
                unripe--;
                queue.offer(new int[]{nh, nr, nc});
            }
        }

        System.out.print(unripe == 0 ? days : -1);
    }
}
