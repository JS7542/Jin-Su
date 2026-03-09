import java.io.*;
import java.util.*;

class Main {
    /*
     * 행 수가 열 수 이상이면 R 연산, 아니면 C 연산을 수행한다.
     * 각 줄의 숫자 빈도를 세고 빈도·숫자 순으로 정렬해 최대 100개까지 다시 채운다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetRow = Integer.parseInt(st.nextToken()) - 1;
        int targetCol = Integer.parseInt(st.nextToken()) - 1;
        int targetValue = Integer.parseInt(st.nextToken());

        int[][] board = new int[100][100];

        for (int row = 0; row < 3; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < 3; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int rowSize = 3;
        int colSize = 3;

        for (int time = 0; time <= 100; time++) {
            if (targetRow < rowSize && targetCol < colSize
                    && board[targetRow][targetCol] == targetValue) {
                System.out.print(time);
                return;
            }

            if (time == 100) break;

            if (rowSize >= colSize) {
                int newColSize = 0;

                for (int row = 0; row < rowSize; row++) {
                    int[] result = operate(board[row], colSize);
                    Arrays.fill(board[row], 0);

                    for (int col = 0; col < result.length; col++) {
                        board[row][col] = result[col];
                    }

                    newColSize = Math.max(newColSize, result.length);
                }

                colSize = Math.min(100, newColSize);
            } else {
                int newRowSize = 0;

                for (int col = 0; col < colSize; col++) {
                    int[] values = new int[rowSize];

                    for (int row = 0; row < rowSize; row++) {
                        values[row] = board[row][col];
                    }

                    int[] result = operate(values, rowSize);

                    for (int row = 0; row < 100; row++) board[row][col] = 0;

                    for (int row = 0; row < result.length; row++) {
                        board[row][col] = result[row];
                    }

                    newRowSize = Math.max(newRowSize, result.length);
                }

                rowSize = Math.min(100, newRowSize);
            }
        }

        System.out.print(-1);
    }

    static int[] operate(int[] values, int length) {
        int[] count = new int[101];

        for (int index = 0; index < length; index++) {
            if (values[index] != 0) count[values[index]]++;
        }

        List<int[]> pairs = new ArrayList<>();

        for (int value = 1; value <= 100; value++) {
            if (count[value] > 0) pairs.add(new int[]{value, count[value]});
        }

        pairs.sort((first, second) -> {
            int compare = Integer.compare(first[1], second[1]);
            return compare != 0 ? compare : Integer.compare(first[0], second[0]);
        });

        int resultLength = Math.min(100, pairs.size() * 2);
        int[] result = new int[resultLength];
        int index = 0;

        for (int[] pair : pairs) {
            if (index >= resultLength) break;
            result[index++] = pair[0];

            if (index >= resultLength) break;
            result[index++] = pair[1];
        }

        return result;
    }
}
