import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int activeCount;
    static int[][] laboratory;
    static List<int[]> viruses = new ArrayList<>();
    static int[] selected;
    static int emptyCount;
    static int answer = Integer.MAX_VALUE;

    /*
     * 바이러스 후보 중 M개를 조합으로 선택한다.
     * 선택한 바이러스를 동시에 BFS 확산시켜 모든 빈칸을 채우는 최소 시간을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        activeCount = Integer.parseInt(st.nextToken());
        laboratory = new int[size][size];
        selected = new int[activeCount];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                laboratory[row][col] = Integer.parseInt(st.nextToken());

                if (laboratory[row][col] == 2) viruses.add(new int[]{row, col});
                else if (laboratory[row][col] == 0) emptyCount++;
            }
        }

        if (emptyCount == 0) {
            System.out.print(0);
            return;
        }

        choose(0, 0);
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void choose(int start, int depth) {
        if (depth == activeCount) {
            answer = Math.min(answer, spread());
            return;
        }

        for (int index = start; index < viruses.size(); index++) {
            selected[depth] = index;
            choose(index + 1, depth + 1);
        }
    }

    static int spread() {
        int[][] time = new int[size][size];

        for (int[] row : time) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();

        for (int index : selected) {
            int[] virus = viruses.get(index);
            queue.offer(virus);
            time[virus[0]][virus[1]] = 0;
        }

        int filled = 0;
        int maximumTime = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                if (laboratory[nr][nc] == 1 || time[nr][nc] != -1) continue;

                time[nr][nc] = time[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});

                if (laboratory[nr][nc] == 0) {
                    filled++;
                    maximumTime = Math.max(maximumTime, time[nr][nc]);
                }
            }
        }

        return filled == emptyCount ? maximumTime : Integer.MAX_VALUE;
    }
}
