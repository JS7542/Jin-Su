import java.io.*;
import java.util.*;

class Solution {
    /*
     * 시작점 2에서 BFS를 수행해 벽이 아닌 상하좌우 칸으로 이동한다.
     * 도착점 3을 방문할 수 있으면 1, 없으면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            char[][] maze = new char[16][];
            int startRow = 0;
            int startCol = 0;

            for (int row = 0; row < 16; row++) {
                maze[row] = br.readLine().toCharArray();

                for (int col = 0; col < 16; col++) {
                    if (maze[row][col] == '2') {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            boolean[][] visited = new boolean[16][16];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startRow, startCol});
            visited[startRow][startCol] = true;
            int reachable = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (maze[current[0]][current[1]] == '3') {
                    reachable = 1;
                    break;
                }

                for (int direction = 0; direction < 4; direction++) {
                    int nr = current[0] + dr[direction];
                    int nc = current[1] + dc[direction];

                    if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16) continue;
                    if (maze[nr][nc] == '1' || visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(reachable).append('\n');
        }

        System.out.print(output);
    }
}
