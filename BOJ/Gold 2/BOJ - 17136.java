import java.io.*;
import java.util.*;

class Main {
    static int[][] paper = new int[10][10];
    static int[] remaining = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    /*
     * 왼쪽 위의 아직 덮지 않은 1을 찾아 가능한 큰 색종이부터 붙인다.
     * 각 크기를 최대 다섯 장만 사용하며 모두 덮은 최소 장수를 백트래킹한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < 10; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < 10; col++) {
                paper[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        search(0);
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void search(int used) {
        if (used >= answer) return;

        int targetRow = -1;
        int targetCol = -1;

        outer:
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (paper[row][col] == 1) {
                    targetRow = row;
                    targetCol = col;
                    break outer;
                }
            }
        }

        if (targetRow == -1) {
            answer = used;
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (remaining[size] == 0 || !canAttach(targetRow, targetCol, size)) {
                continue;
            }

            attach(targetRow, targetCol, size, 0);
            remaining[size]--;
            search(used + 1);
            remaining[size]++;
            attach(targetRow, targetCol, size, 1);
        }
    }

    static boolean canAttach(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) return false;

        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (paper[r][c] == 0) return false;
            }
        }

        return true;
    }

    static void attach(int row, int col, int size, int value) {
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                paper[r][c] = value;
            }
        }
    }
}
