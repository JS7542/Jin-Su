import java.io.*;
import java.util.*;

class Solution {
    /*
     * 시작점 2에서 상하좌우 BFS를 수행한다.
     * 벽을 제외한 칸을 방문하며 도착점 3에 도달할 수 있는지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            char[][] maze = new char[100][];
            int startRow = 0;
            int startCol = 0;

            for (int row = 0; row < 100; row++) {
                maze[row] = br.readLine().toCharArray();

                for (int col = 0; col < 100; col++) {
                    if (maze[row][col] == '2') {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            boolean[][] visited = new boolean[100][100];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startRow, startCol});
            visited[startRow][startCol] = true;
            int answer = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (maze[current[0]][current[1]] == '3') {
                    answer = 1;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];

                    if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) continue;
                    if (visited[nr][nc] || maze[nr][nc] == '1') continue;

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
