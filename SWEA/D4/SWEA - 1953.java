import java.io.*;
import java.util.*;

class Solution {
    static final int[][] DIRECTIONS = {
        {},
        {0, 1, 2, 3},
        {0, 1},
        {2, 3},
        {0, 3},
        {1, 3},
        {1, 2},
        {0, 2}
    };

    /*
     * 맨홀 위치에서 시간 제한까지 BFS를 수행한다.
     * 현재 터널의 출구 방향과 인접 터널의 반대 방향이 모두 연결될 때만 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[] opposite = {1, 0, 3, 2};

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int timeLimit = Integer.parseInt(st.nextToken());

            int[][] map = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < cols; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] time = new int[rows][cols];
            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[]{startRow, startCol});
            time[startRow][startCol] = 1;
            int answer = 1;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if (time[row][col] == timeLimit) continue;

                for (int direction : DIRECTIONS[map[row][col]]) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (map[nr][nc] == 0 || time[nr][nc] != 0) continue;
                    if (!contains(DIRECTIONS[map[nr][nc]], opposite[direction])) continue;

                    time[nr][nc] = time[row][col] + 1;
                    answer++;
                    queue.offer(new int[]{nr, nc});
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static boolean contains(int[] directions, int target) {
        for (int direction : directions) {
            if (direction == target) return true;
        }

        return false;
    }
}
