import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int[][] board;
    static boolean[] diagonalDown;
    static boolean[] diagonalUp;
    static int[] answer = new int[2];

    /*
     * 검은 칸과 흰 칸은 서로 공격하지 않으므로 두 색을 분리해 백트래킹한다.
     * 두 대각선 점유 여부를 관리하며 배치 가능한 비숍 최대 수를 각각 구해 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        board = new int[size][size];

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        diagonalDown = new boolean[size * 2];
        diagonalUp = new boolean[size * 2];

        search(0, 0, 0);
        search(0, 1, 0);

        System.out.print(answer[0] + answer[1]);
    }

    static void search(int position, int color, int count) {
        answer[color] = Math.max(answer[color], count);

        for (int index = position; index < size * size; index++) {
            int row = index / size;
            int col = index % size;

            if ((row + col) % 2 != color || board[row][col] == 0) continue;

            int down = row - col + size;
            int up = row + col;

            if (diagonalDown[down] || diagonalUp[up]) continue;

            diagonalDown[down] = true;
            diagonalUp[up] = true;
            search(index + 1, color, count + 1);
            diagonalDown[down] = false;
            diagonalUp[up] = false;
        }
    }
}
