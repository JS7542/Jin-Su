import java.io.*;
import java.util.*;

class Main {
    /*
     * 데스 나이트의 여섯 이동 방향을 사용해 BFS를 수행한다.
     * 목표 칸의 최단 이동 횟수를 구하고 도달하지 못하면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int targetRow = Integer.parseInt(st.nextToken());
        int targetCol = Integer.parseInt(st.nextToken());

        int[][] distance = new int[size][size];

        for (int[] row : distance) Arrays.fill(row, -1);

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 6; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                if (distance[nr][nc] != -1) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        System.out.print(distance[targetRow][targetCol]);
    }
}
