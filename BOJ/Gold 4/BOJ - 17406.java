import java.io.*;
import java.util.*;

class Main {
    static int rows;
    static int cols;
    static int operationCount;
    static int[][] original;
    static int[][] operations;
    static boolean[] used;
    static int[] order;
    static int answer = Integer.MAX_VALUE;

    /*
     * 회전 연산의 모든 실행 순서를 순열로 만든다.
     * 각 순서마다 배열을 복사해 회전시키고 행 합의 최솟값을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        operationCount = Integer.parseInt(st.nextToken());

        original = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                original[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        operations = new int[operationCount][3];

        for (int i = 0; i < operationCount; i++) {
            st = new StringTokenizer(br.readLine());

            operations[i][0] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][1] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        used = new boolean[operationCount];
        order = new int[operationCount];

        permute(0);
        System.out.print(answer);
    }

    static void permute(int depth) {
        if (depth == operationCount) {
            int[][] board = copy(original);

            for (int index : order) rotate(board, operations[index]);

            for (int[] row : board) {
                int sum = 0;

                for (int value : row) sum += value;

                answer = Math.min(answer, sum);
            }

            return;
        }

        for (int index = 0; index < operationCount; index++) {
            if (used[index]) continue;

            used[index] = true;
            order[depth] = index;
            permute(depth + 1);
            used[index] = false;
        }
    }

    static void rotate(int[][] board, int[] operation) {
        int centerRow = operation[0];
        int centerCol = operation[1];
        int size = operation[2];

        for (int layer = 1; layer <= size; layer++) {
            int top = centerRow - layer;
            int bottom = centerRow + layer;
            int left = centerCol - layer;
            int right = centerCol + layer;

            int saved = board[top][left];

            for (int row = top; row < bottom; row++) {
                board[row][left] = board[row + 1][left];
            }

            for (int col = left; col < right; col++) {
                board[bottom][col] = board[bottom][col + 1];
            }

            for (int row = bottom; row > top; row--) {
                board[row][right] = board[row - 1][right];
            }

            for (int col = right; col > left + 1; col--) {
                board[top][col] = board[top][col - 1];
            }

            board[top][left + 1] = saved;
        }
    }

    static int[][] copy(int[][] source) {
        int[][] copied = new int[rows][cols];

        for (int row = 0; row < rows; row++) copied[row] = source[row].clone();

        return copied;
    }
}
