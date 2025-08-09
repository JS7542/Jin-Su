import java.io.*;
import java.util.*;

class Solution {
    static int[][] board = new int[4][4];
    static Set<Integer> numbers;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    /*
     * 모든 칸에서 시작해 상하좌우로 여섯 번 이동하며 7자리 숫자를 만든다.
     * 만들어진 숫자를 집합에 저장해 서로 다른 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            for (int row = 0; row < 4; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < 4; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            numbers = new HashSet<>();

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    search(row, col, 1, board[row][col]);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(numbers.size()).append('\n');
        }

        System.out.print(output);
    }

    static void search(int row, int col, int length, int value) {
        if (length == 7) {
            numbers.add(value);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;

            search(nr, nc, length + 1, value * 10 + board[nr][nc]);
        }
    }
}
