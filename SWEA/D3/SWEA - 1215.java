import java.io.*;

class Solution {
    /*
     * 8×8 배열의 모든 가로와 세로 길이 N 구간을 확인한다.
     * 양 끝 문자를 비교해 회문인 구간 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int length = Integer.parseInt(br.readLine());
            char[][] board = new char[8][];

            for (int i = 0; i < 8; i++) board[i] = br.readLine().toCharArray();

            int answer = 0;

            for (int r = 0; r < 8; r++) {
                for (int start = 0; start + length <= 8; start++) {
                    if (horizontal(board, r, start, length)) answer++;
                }
            }

            for (int c = 0; c < 8; c++) {
                for (int start = 0; start + length <= 8; start++) {
                    if (vertical(board, c, start, length)) answer++;
                }
            }

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static boolean horizontal(char[][] board, int row, int start, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (board[row][start + i] != board[row][start + length - 1 - i]) return false;
        }
        return true;
    }

    static boolean vertical(char[][] board, int col, int start, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (board[start + i][col] != board[start + length - 1 - i][col]) return false;
        }
        return true;
    }
}
