import java.io.*;
import java.util.*;

class Solution {
    /*
     * 이동 방향마다 한 줄씩 숫자를 추출해 0을 제거하고 같은 수를 한 번만 합친다.
     * 합쳐진 줄을 이동 방향 쪽부터 다시 채워 최종 보드를 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            int[][] board = new int[size][size];

            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            move(board, direction);

            output.append('#').append(tc).append('\n');

            for (int[] row : board) {
                for (int value : row) output.append(value).append(' ');
                output.append('\n');
            }
        }

        System.out.print(output);
    }

    static void move(int[][] board, String direction) {
        int size = board.length;

        for (int line = 0; line < size; line++) {
            List<Integer> values = new ArrayList<>();

            for (int index = 0; index < size; index++) {
                int row;
                int col;

                if (direction.equals("left")) {
                    row = line;
                    col = index;
                } else if (direction.equals("right")) {
                    row = line;
                    col = size - 1 - index;
                } else if (direction.equals("up")) {
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

            for (int index = 0; index < size; index++) {
                int row;
                int col;

                if (direction.equals("left")) {
                    row = line;
                    col = index;
                } else if (direction.equals("right")) {
                    row = line;
                    col = size - 1 - index;
                } else if (direction.equals("up")) {
                    row = index;
                    col = line;
                } else {
                    row = size - 1 - index;
                    col = line;
                }

                board[row][col] = index < merged.size()
                        ? merged.get(index) : 0;
            }
        }
    }
}
