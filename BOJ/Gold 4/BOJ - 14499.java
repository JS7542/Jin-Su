import java.io.*;
import java.util.*;

class Main {
    /*
     * 주사위의 위·아래·동·서·남·북 면 값을 배열로 관리한다.
     * 명령 방향으로 굴린 뒤 지도와 바닥면 사이 복사 규칙을 적용하고 윗면을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int commands = Integer.parseInt(st.nextToken());

        int[][] map = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < cols; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6];
        int[] dr = {0, 0, 0, -1, 1};
        int[] dc = {0, 1, -1, 0, 0};

        st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < commands; i++) {
            int direction = Integer.parseInt(st.nextToken());
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            roll(dice, direction);
            row = nr;
            col = nc;

            if (map[row][col] == 0) {
                map[row][col] = dice[1];
            } else {
                dice[1] = map[row][col];
                map[row][col] = 0;
            }

            output.append(dice[0]).append('\n');
        }

        System.out.print(output);
    }

    static void roll(int[] dice, int direction) {
        int top = dice[0];
        int bottom = dice[1];
        int east = dice[2];
        int west = dice[3];
        int north = dice[4];
        int south = dice[5];

        if (direction == 1) {
            dice[0] = west;
            dice[1] = east;
            dice[2] = top;
            dice[3] = bottom;
        } else if (direction == 2) {
            dice[0] = east;
            dice[1] = west;
            dice[2] = bottom;
            dice[3] = top;
        } else if (direction == 3) {
            dice[0] = south;
            dice[1] = north;
            dice[4] = top;
            dice[5] = bottom;
        } else {
            dice[0] = north;
            dice[1] = south;
            dice[4] = bottom;
            dice[5] = top;
        }
    }
}
