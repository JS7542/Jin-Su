import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] lab;
    static int answer;
    static List<int[]> empty = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    /*
     * 빈 칸 중 세 곳을 조합으로 선택해 벽을 세운다.
     * 각 경우 바이러스를 BFS로 확산시킨 뒤 남은 안전 영역의 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < m; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());

                if (lab[r][c] == 0) empty.add(new int[]{r, c});
                else if (lab[r][c] == 2) viruses.add(new int[]{r, c});
            }
        }

        chooseWalls(0, 0);
        System.out.print(answer);
    }

    static void chooseWalls(int start, int count) {
        if (count == 3) {
            answer = Math.max(answer, simulate());
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            int[] cell = empty.get(i);
            lab[cell[0]][cell[1]] = 1;
            chooseWalls(i + 1, count + 1);
            lab[cell[0]][cell[1]] = 0;
        }
    }

    static int simulate() {
        int[][] copied = new int[n][m];
        for (int r = 0; r < n; r++) copied[r] = lab[r].clone();

        Queue<int[]> queue = new ArrayDeque<>();

        for (int[] virus : viruses) queue.offer(virus.clone());

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (copied[nr][nc] != 0) continue;

                copied[nr][nc] = 2;
                queue.offer(new int[]{nr, nc});
            }
        }

        int safe = 0;
        for (int[] row : copied) for (int value : row) if (value == 0) safe++;

        return safe;
    }
}
