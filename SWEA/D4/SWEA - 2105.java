import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static int[][] cafe;
    static boolean[] eaten;
    static int answer;
    static final int[] DR = {1, 1, -1, -1};
    static final int[] DC = {1, -1, -1, 1};

    /*
     * 각 카페를 시작점으로 네 대각선 방향을 순서대로 이동한다.
     * 같은 디저트를 다시 먹지 않으며 시작점으로 돌아오는 경로의 최대 길이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            size = Integer.parseInt(br.readLine());
            cafe = new int[size][size];

            for (int row = 0; row < size; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    cafe[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1;

            for (int startRow = 0; startRow < size; startRow++) {
                for (int startCol = 0; startCol < size; startCol++) {
                    eaten = new boolean[101];
                    eaten[cafe[startRow][startCol]] = true;
                    search(startRow, startCol, startRow, startCol, 0, 1);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(
            int row,
            int col,
            int startRow,
            int startCol,
            int direction,
            int count
    ) {
        for (int nextDirection = direction;
                nextDirection <= Math.min(3, direction + 1);
                nextDirection++) {
            int nr = row + DR[nextDirection];
            int nc = col + DC[nextDirection];

            if (nr == startRow && nc == startCol) {
                if (nextDirection == 3 && count >= 4) {
                    answer = Math.max(answer, count);
                }
                continue;
            }

            if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;

            int dessert = cafe[nr][nc];

            if (eaten[dessert]) continue;

            eaten[dessert] = true;
            search(
                    nr,
                    nc,
                    startRow,
                    startCol,
                    nextDirection,
                    count + 1
            );
            eaten[dessert] = false;
        }
    }
}
