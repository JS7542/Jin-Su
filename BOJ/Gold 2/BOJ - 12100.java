import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int answer;

    /*
     * 최대 다섯 번의 네 방향 이동을 모두 DFS로 탐색한다.
     * 각 이동은 한 줄의 0을 제거하고 같은 숫자를 한 번만 합쳐 새 보드를 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int[][] board = new int[size][size];

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, board[row][col]);
            }
        }

        search(board, 0);
        System.out.print(answer);
    }

    static void search(int[][] board, int depth) {
        if (depth == 5) return;

        for (int direction = 0; direction < 4; direction++) {
            int[][] moved = move(board, direction);

            for (int[] row : moved) {
                for (int value : row) answer = Math.max(answer, value);
            }

            search(moved, depth + 1);
        }
    }

    static int[][] move(int[][] board, int direction) {
        int[][] result = new int[size][size];

        for (int line = 0; line < size; line++) {
            List<Integer> values = new ArrayList<>();

            for (int index = 0; index < size; index++) {
                int row;
                int col;

                if (direction == 0) {
                    row = line;
                    col = index;
                } else if (direction == 1) {
                    row = line;
                    col = size - 1 - index;
                } else if (direction == 2) {
                    row = index;
                    col = line;
                } else {
                    row = size - 1 - index;
                    col = line;
                }

                if (board[row][col] != 0) values.add(board[row][col]);
            }

            List<Integer> merged = new ArrayList<>();

            for (int index = 0; index < values.size(); index++) {
                int value = values.get(index);

                if (index + 1 < values.size()
                        && values.get(index + 1) == value) {
                    merged.add(value * 2);
                    index++;
                } else {
                    merged.add(value);
                }
            }

            for (int index = 0; index < merged.size(); index++) {
                int row;
                int col;

                if (direction == 0) {
                    row = line;
                    col = index;
                } else if (direction == 1) {
                    row = line;
                    col = size - 1 - index;
                } else if (direction == 2) {
                    row = index;
                    col = line;
                } else {
                    row = size - 1 - index;
                    col = line;
                }

                result[row][col] = merged.get(index);
            }
        }

        return result;
    }
}
