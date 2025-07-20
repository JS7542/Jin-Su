import java.io.*;
import java.util.*;

class Solution {
    /*
     * 100×100 배열의 각 행과 열의 합을 계산한다.
     * 두 대각선 합까지 포함해 가장 큰 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] board = new int[100][100];

            for (int row = 0; row < 100; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < 100; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            int diagonal = 0;
            int reverseDiagonal = 0;

            for (int row = 0; row < 100; row++) {
                int rowSum = 0;
                int colSum = 0;

                for (int col = 0; col < 100; col++) {
                    rowSum += board[row][col];
                    colSum += board[col][row];
                }

                answer = Math.max(answer, Math.max(rowSum, colSum));
                diagonal += board[row][row];
                reverseDiagonal += board[row][99 - row];
            }

            answer = Math.max(answer, Math.max(diagonal, reverseDiagonal));

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
