import java.io.*;
import java.util.*;

class Main {
    /*
     * 물이 퍼지는 시간을 먼저 BFS로 계산한다.
     * 고슴도치는 물이 도착하기 전인 칸만 이동하며 굴까지의 최단 시간을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][cols];
        int[][] waterTime = new int[rows][cols];

        for (int[] row : waterTime) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> water = new ArrayDeque<>();
        int startRow = 0;
        int startCol = 0;
        int destinationRow = 0;
        int destinationCol = 0;

        for (int row = 0; row < rows; row++) {
            map[row] = br.readLine().toCharArray();

            for (int col = 0; col < cols; col++) {
                if (map[row][col] == '*') {
                    water.offer(new int[]{row, col});
                    waterTime[row][col] = 0;
                } else if (map[row][col] == 'S') {
                    startRow = row;
                    startCol = col;
                } else if (map[row][col] == 'D') {
                    destinationRow = row;
                    destinationCol = col;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!water.isEmpty()) {
            int[] current = water.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
                if (waterTime[nr][nc] != Integer.MAX_VALUE) continue;

                waterTime[nr][nc] = waterTime[current[0]][current[1]] + 1;
                water.offer(new int[]{nr, nc});
            }
        }

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == destinationRow && current[1] == destinationCol) {
                System.out.print(distance[current[0]][current[1]]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == 'X' || distance[nr][nc] != -1) continue;

                int nextTime = distance[current[0]][current[1]] + 1;

                if (map[nr][nc] != 'D' && waterTime[nr][nc] <= nextTime) continue;

                distance[nr][nc] = nextTime;
                queue.offer(new int[]{nr, nc});
            }
        }

        System.out.print("KAKTUS");
    }
}
