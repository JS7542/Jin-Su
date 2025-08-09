import java.io.*;
import java.util.*;

class Solution {
    /*
     * 맨 위의 각 출발점에서 사다리를 따라 아래까지 이동한다.
     * 좌우 이동을 우선하고 전체 이동 횟수가 가장 작은 출발 열을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];

            for (int row = 0; row < 100; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < 100; col++) {
                    ladder[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            int shortest = Integer.MAX_VALUE;

            for (int start = 0; start < 100; start++) {
                if (ladder[0][start] == 0) continue;

                int row = 0;
                int col = start;
                int moves = 0;

                while (row < 99) {
                    if (col > 0 && ladder[row][col - 1] == 1) {
                        while (col > 0 && ladder[row][col - 1] == 1) {
                            col--;
                            moves++;
                        }
                    } else if (col < 99 && ladder[row][col + 1] == 1) {
                        while (col < 99 && ladder[row][col + 1] == 1) {
                            col++;
                            moves++;
                        }
                    }

                    row++;
                    moves++;
                }

                if (moves < shortest) {
                    shortest = moves;
                    answer = start;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
