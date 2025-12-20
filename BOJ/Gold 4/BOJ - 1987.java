import java.io.*;
import java.util.*;

class Main {
    static int rows;
    static int cols;
    static char[][] board;
    static int answer;
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    /*
     * 사용한 알파벳을 26비트 마스크로 관리한다.
     * 아직 사용하지 않은 알파벳 칸으로 DFS하며 이동 가능한 최대 칸 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        board = new char[rows][];
        for (int row = 0; row < rows; row++) board[row] = br.readLine().toCharArray();

        int startMask = 1 << (board[0][0] - 'A');
        search(0, 0, startMask, 1);

        System.out.print(answer);
    }

    static void search(int row, int col, int mask, int length) {
        answer = Math.max(answer, length);

        for (int direction = 0; direction < 4; direction++) {
            int nr = row + DR[direction];
            int nc = col + DC[direction];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            int bit = 1 << (board[nr][nc] - 'A');

            if ((mask & bit) == 0) {
                search(nr, nc, mask | bit, length + 1);
            }
        }
    }
}
