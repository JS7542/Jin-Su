import java.io.*;
import java.util.*;

class Main {
    /*
     * 빈 방 이동 비용은 0, 벽을 부수는 비용은 1로 두고 0-1 BFS를 수행한다.
     * 비용 0 이동은 덱 앞에, 비용 1 이동은 덱 뒤에 넣어 최소 벽 파괴 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());

        char[][] maze = new char[rows][];
        for (int row = 0; row < rows; row++) maze[row] = br.readLine().toCharArray();

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int cost = maze[nr][nc] - '0';
                int nextDistance = distance[current[0]][current[1]] + cost;

                if (nextDistance >= distance[nr][nc]) continue;

                distance[nr][nc] = nextDistance;

                if (cost == 0) deque.offerFirst(new int[]{nr, nc});
                else deque.offerLast(new int[]{nr, nc});
            }
        }

        System.out.print(distance[rows - 1][cols - 1]);
    }
}
