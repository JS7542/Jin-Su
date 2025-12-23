import java.io.*;
import java.util.*;

class Main {
    /*
     * 매 초 미세먼지를 동시에 확산시킨 뒤 공기청정기 위·아래 순환 경로를 따라 공기를 이동한다.
     * T초 후 공기청정기 칸을 제외한 미세먼지 총합을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int seconds = Integer.parseInt(st.nextToken());

        int[][] room = new int[rows][cols];
        int upper = -1;
        int lower = -1;

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                room[row][col] = Integer.parseInt(st.nextToken());

                if (room[row][col] == -1) {
                    if (upper == -1) upper = row;
                    else lower = row;
                }
            }
        }

        for (int time = 0; time < seconds; time++) {
            spread(room, upper, lower);
            purify(room, upper, lower);
        }

        int answer = 0;

        for (int[] row : room) {
            for (int value : row) {
                if (value > 0) answer += value;
            }
        }

        System.out.print(answer);
    }

    static void spread(int[][] room, int upper, int lower) {
        int rows = room.length;
        int cols = room[0].length;
        int[][] next = new int[rows][cols];

        next[upper][0] = -1;
        next[lower][0] = -1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (room[row][col] <= 0) continue;

                int amount = room[row][col] / 5;
                int count = 0;

                for (int direction = 0; direction < 4; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (room[nr][nc] == -1) continue;

                    next[nr][nc] += amount;
                    count++;
                }

                next[row][col] += room[row][col] - amount * count;
            }
        }

        for (int row = 0; row < rows; row++) {
            room[row] = next[row];
        }
    }

    static void purify(int[][] room, int upper, int lower) {
        int rows = room.length;
        int cols = room[0].length;

        for (int row = upper - 1; row > 0; row--) room[row][0] = room[row - 1][0];
        for (int col = 0; col < cols - 1; col++) room[0][col] = room[0][col + 1];
        for (int row = 0; row < upper; row++) room[row][cols - 1] = room[row + 1][cols - 1];
        for (int col = cols - 1; col > 1; col--) room[upper][col] = room[upper][col - 1];
        room[upper][1] = 0;

        for (int row = lower + 1; row < rows - 1; row++) room[row][0] = room[row + 1][0];
        for (int col = 0; col < cols - 1; col++) room[rows - 1][col] = room[rows - 1][col + 1];
        for (int row = rows - 1; row > lower; row--) room[row][cols - 1] = room[row - 1][cols - 1];
        for (int col = cols - 1; col > 1; col--) room[lower][col] = room[lower][col - 1];
        room[lower][1] = 0;

        room[upper][0] = -1;
        room[lower][0] = -1;
    }
}
