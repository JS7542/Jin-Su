import java.io.*;
import java.util.*;

class Main {
    /*
     * 값이 1이고 아직 방문하지 않은 칸마다 BFS를 시작한다.
     * 각 연결 요소 크기를 저장한 뒤 오름차순으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < n; c++) map[r][c] = line.charAt(c) - '0';
        }

        boolean[][] visited = new boolean[n][n];
        List<Integer> sizes = new ArrayList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 0 || visited[r][c]) continue;

                int size = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{r, c});
                visited[r][c] = true;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    size++;

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                sizes.add(size);
            }
        }

        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append('\n');
        for (int size : sizes) sb.append(size).append('\n');

        System.out.print(sb);
    }
}
