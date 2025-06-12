import java.io.*;
import java.util.*;

class Main {
    /*
     * 목표 지점 2에서 BFS를 시작해 이동 가능한 땅의 최단 거리를 계산한다.
     * 원래 갈 수 있는 땅인데 방문하지 못한 칸은 -1로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] map = new int[rows][cols];
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());

                if (map[row][col] == 2) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int[][] distance = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            Arrays.fill(distance[row], -1);

            for (int col = 0; col < cols; col++) {
                if (map[row][col] == 0) distance[row][col] = 0;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == 0 || distance[nr][nc] != -1) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        StringBuilder output = new StringBuilder();

        for (int[] row : distance) {
            for (int value : row) output.append(value).append(' ');
            output.append('\n');
        }

        System.out.print(output);
    }
}
