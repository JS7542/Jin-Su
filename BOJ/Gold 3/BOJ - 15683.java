import java.io.*;
import java.util.*;

class Main {
    static int rows;
    static int cols;
    static int[][] office;
    static List<int[]> cameras = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static final int[][][] DIRECTIONS = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };

    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    /*
     * 각 CCTV의 가능한 방향 조합을 백트래킹한다.
     * 선택한 방향으로 감시 영역을 표시하고 모든 CCTV 처리 후 사각지대 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        office = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                office[row][col] = Integer.parseInt(st.nextToken());

                if (office[row][col] >= 1 && office[row][col] <= 5) {
                    cameras.add(new int[]{row, col, office[row][col]});
                }
            }
        }

        search(0, office);
        System.out.print(answer);
    }

    static void search(int index, int[][] board) {
        if (index == cameras.size()) {
            int blind = 0;

            for (int[] row : board) {
                for (int value : row) {
                    if (value == 0) blind++;
                }
            }

            answer = Math.min(answer, blind);
            return;
        }

        int[] camera = cameras.get(index);

        for (int[] directions : DIRECTIONS[camera[2]]) {
            int[][] copied = copy(board);

            for (int direction : directions) {
                watch(camera[0], camera[1], direction, copied);
            }

            search(index + 1, copied);
        }
    }

    static void watch(int row, int col, int direction, int[][] board) {
        int nr = row + DR[direction];
        int nc = col + DC[direction];

        while (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
            if (board[nr][nc] == 6) break;

            if (board[nr][nc] == 0) board[nr][nc] = -1;

            nr += DR[direction];
            nc += DC[direction];
        }
    }

    static int[][] copy(int[][] board) {
        int[][] copied = new int[rows][cols];

        for (int row = 0; row < rows; row++) copied[row] = board[row].clone();

        return copied;
    }
}
