import java.io.*;
import java.util.*;

class Main {
    /*
     * 나이트의 8가지 이동을 간선으로 보고 BFS를 수행한다.
     * 목표 칸을 처음 방문했을 때의 거리가 최소 이동 횟수다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        while (tests-- > 0) {
            int size = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetR = Integer.parseInt(st.nextToken());
            int targetC = Integer.parseInt(st.nextToken());

            int[][] distance = new int[size][size];
            for (int[] row : distance) Arrays.fill(row, -1);

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startR, startC});
            distance[startR][startC] = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                for (int d = 0; d < 8; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];

                    if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                    if (distance[nr][nc] != -1) continue;

                    distance[nr][nc] = distance[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }

            output.append(distance[targetR][targetC]).append('\n');
        }

        System.out.print(output);
    }
}
