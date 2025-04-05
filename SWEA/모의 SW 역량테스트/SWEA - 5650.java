import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static int[][] board;
    static List<int[]>[] wormholes;
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    static final int[][] REFLECT = {
        {},
        {2, 3, 1, 0},
        {1, 3, 0, 2},
        {3, 2, 0, 1},
        {2, 0, 3, 1},
        {2, 3, 0, 1}
    };

    /*
     * 모든 빈칸과 네 방향에서 핀볼을 출발시킨다.
     * 블록 반사와 웜홀 이동을 적용하며 시작점 또는 블랙홀에 도달할 때까지의 충돌 수 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];
            wormholes = new ArrayList[11];

            for (int number = 6; number <= 10; number++) {
                wormholes[number] = new ArrayList<>();
            }

            for (int row = 0; row < size; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());

                    if (board[row][col] >= 6) {
                        wormholes[board[row][col]].add(new int[]{row, col});
                    }
                }
            }

            int answer = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board[row][col] != 0) continue;

                    for (int direction = 0; direction < 4; direction++) {
                        answer = Math.max(
                                answer,
                                simulate(row, col, direction)
                        );
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static int simulate(int startRow, int startCol, int direction) {
        int row = startRow;
        int col = startCol;
        int score = 0;

        while (true) {
            row += DR[direction];
            col += DC[direction];

            if (row < 0 || row >= size || col < 0 || col >= size) {
                score++;
                direction = (direction + 2) % 4;
                continue;
            }

            if ((row == startRow && col == startCol) || board[row][col] == -1) {
                return score;
            }

            int block = board[row][col];

            if (block >= 1 && block <= 5) {
                direction = REFLECT[block][direction];
                score++;
            } else if (block >= 6) {
                List<int[]> pair = wormholes[block];
                int[] first = pair.get(0);
                int[] second = pair.get(1);

                if (row == first[0] && col == first[1]) {
                    row = second[0];
                    col = second[1];
                } else {
                    row = first[0];
                    col = first[1];
                }
            }
        }
    }
}
