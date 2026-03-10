import java.io.*;
import java.util.*;

class Main {
    /*
     * 불이 각 칸에 도착하는 시간을 다중 시작점 BFS로 계산한다.
     * 지훈이는 불보다 먼저 도착할 수 있는 칸만 이동하고 경계 밖으로 나가면 탈출한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][cols];
        int[][] fireTime = new int[rows][cols];

        for (int[] row : fireTime) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> fire = new ArrayDeque<>();
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows; row++) {
            map[row] = br.readLine().toCharArray();

            for (int col = 0; col < cols; col++) {
                if (map[row][col] == 'F') {
                    fire.offer(new int[]{row, col});
                    fireTime[row][col] = 0;
                } else if (map[row][col] == 'J') {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!fire.isEmpty()) {
            int[] current = fire.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == '#' || fireTime[nr][nc] != Integer.MAX_VALUE) continue;

                fireTime[nr][nc] = fireTime[current[0]][current[1]] + 1;
                fire.offer(new int[]{nr, nc});
            }
        }

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nextTime = distance[current[0]][current[1]] + 1;

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    System.out.print(nextTime);
                    return;
                }

                if (map[nr][nc] == '#' || distance[nr][nc] != -1) continue;
                if (fireTime[nr][nc] <= nextTime) continue;

                distance[nr][nc] = nextTime;
                queue.offer(new int[]{nr, nc});
            }
        }

        System.out.print("IMPOSSIBLE");
    }
}
