import java.io.*;
import java.util.*;

class Main {
    /*
     * 위치와 진행 방향을 상태로 두고 거울 개수를 비용으로 다익스트라 탐색한다.
     * 같은 방향 이동은 비용 0, 방향 전환은 비용 1로 처리한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][];
        List<int[]> points = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            map[row] = br.readLine().toCharArray();

            for (int col = 0; col < cols; col++) {
                if (map[row][col] == 'C') points.add(new int[]{row, col});
            }
        }

        int[][][] distance = new int[rows][cols][4];

        for (int[][] row : distance) {
            for (int[] cell : row) Arrays.fill(cell, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state[3])
        );

        int[] start = points.get(0);
        int[] target = points.get(1);

        for (int direction = 0; direction < 4; direction++) {
            distance[start[0]][start[1]][direction] = 0;
            queue.offer(new int[]{start[0], start[1], direction, 0});
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int direction = current[2];
            int mirrors = current[3];

            if (mirrors != distance[row][col][direction]) continue;

            for (int nextDirection = 0; nextDirection < 4; nextDirection++) {
                int nr = row + dr[nextDirection];
                int nc = col + dc[nextDirection];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == '*') continue;

                int nextMirrors = mirrors
                        + (direction == nextDirection ? 0 : 1);

                if (nextMirrors < distance[nr][nc][nextDirection]) {
                    distance[nr][nc][nextDirection] = nextMirrors;
                    queue.offer(new int[]{
                        nr, nc, nextDirection, nextMirrors
                    });
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int direction = 0; direction < 4; direction++) {
            answer = Math.min(
                    answer,
                    distance[target[0]][target[1]][direction]
            );
        }

        System.out.print(answer);
    }
}
