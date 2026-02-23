import java.io.*;
import java.util.*;

class Main {
    /*
     * 현재 칸을 청소하고 왼쪽 방향부터 네 방향을 차례로 확인한다.
     * 청소할 칸이 없으면 후진하고 뒤가 벽이면 작동을 종료한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        int[][] room = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < cols; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] cleaned = new boolean[rows][cols];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int answer = 0;

        while (true) {
            if (!cleaned[row][col]) {
                cleaned[row][col] = true;
                answer++;
            }

            boolean moved = false;

            for (int turn = 0; turn < 4; turn++) {
                direction = (direction + 3) % 4;
                int nr = row + dr[direction];
                int nc = col + dc[direction];

                if (room[nr][nc] == 0 && !cleaned[nr][nc]) {
                    row = nr;
                    col = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            int backDirection = (direction + 2) % 4;
            int backRow = row + dr[backDirection];
            int backCol = col + dc[backDirection];

            if (room[backRow][backCol] == 1) break;

            row = backRow;
            col = backCol;
        }

        System.out.print(answer);
    }
}
