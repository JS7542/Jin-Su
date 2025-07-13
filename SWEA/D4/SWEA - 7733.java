import java.io.*;
import java.util.*;

class Solution {
    /*
     * 요정이 먹은 날짜를 0부터 최대 맛까지 시도한다.
     * 해당 날짜보다 맛이 큰 치즈 칸들의 연결 요소 개수를 BFS로 세어 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cheese = new int[n][n];
            int maximumTaste = 0;

            for (int row = 0; row < n; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    cheese[row][col] = Integer.parseInt(st.nextToken());
                    maximumTaste = Math.max(maximumTaste, cheese[row][col]);
                }
            }

            int answer = 1;

            for (int day = 1; day <= maximumTaste; day++) {
                boolean[][] visited = new boolean[n][n];
                int groups = 0;

                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        if (visited[row][col] || cheese[row][col] <= day) continue;

                        groups++;
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;

                        while (!queue.isEmpty()) {
                            int[] current = queue.poll();

                            for (int d = 0; d < 4; d++) {
                                int nr = current[0] + dr[d];
                                int nc = current[1] + dc[d];

                                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                                if (visited[nr][nc] || cheese[nr][nc] <= day) continue;

                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }

                answer = Math.max(answer, groups);
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
