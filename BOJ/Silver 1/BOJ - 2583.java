import java.io.*;
import java.util.*;

class Main {
    /*
     * 직사각형이 차지하는 칸을 미리 표시한다.
     * 표시되지 않은 칸의 연결 영역을 BFS로 탐색해 넓이를 오름차순 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int rectangles = Integer.parseInt(st.nextToken());

        boolean[][] blocked = new boolean[rows][cols];

        for (int i = 0; i < rectangles; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) blocked[r][c] = true;
            }
        }

        List<Integer> areas = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (blocked[r][c]) continue;

                int area = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{r, c});
                blocked[r][c] = true;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    area++;

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (blocked[nr][nc]) continue;

                        blocked[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                areas.add(area);
            }
        }

        Collections.sort(areas);
        StringBuilder output = new StringBuilder();
        output.append(areas.size()).append('\n');
        for (int area : areas) output.append(area).append(' ');

        System.out.print(output);
    }
}
