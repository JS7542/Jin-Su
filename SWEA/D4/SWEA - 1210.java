import java.io.*;
import java.util.*;

class Solution {
    /*
     * 도착점 2가 있는 맨 아래 칸에서 위쪽으로 역추적한다.
     * 좌우 길이 있으면 먼저 이동하고, 없을 때만 위로 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] board = new int[100][100];
            int column = 0;

            for (int r = 0; r < 100; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int c = 0; c < 100; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                    if (r == 99 && board[r][c] == 2) column = c;
                }
            }

            int row = 99;

            while (row > 0) {
                if (column > 0 && board[row][column - 1] == 1) {
                    while (column > 0 && board[row][column - 1] == 1) column--;
                    row--;
                } else if (column < 99 && board[row][column + 1] == 1) {
                    while (column < 99 && board[row][column + 1] == 1) column++;
                    row--;
                } else {
                    row--;
                }
            }

            output.append('#').append(tc).append(' ').append(column).append('\n');
        }

        System.out.print(output);
    }
}
