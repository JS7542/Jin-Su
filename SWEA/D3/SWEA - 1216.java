import java.io.*;

class Solution {
    /*
     * 길이를 100부터 줄이며 모든 가로·세로 구간을 확인한다.
     * 처음 발견한 회문 길이가 가능한 최댓값이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            char[][] board = new char[100][];

            for (int row = 0; row < 100; row++) {
                board[row] = br.readLine().toCharArray();
            }

            int answer = 1;

            search:
            for (int length = 100; length >= 1; length--) {
                for (int fixed = 0; fixed < 100; fixed++) {
                    for (int start = 0; start + length <= 100; start++) {
                        if (horizontal(board, fixed, start, length)
                                || vertical(board, fixed, start, length)) {
                            answer = length;
                            break search;
                        }
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    private static boolean horizontal(
            char[][] board,
            int row,
            int start,
            int length
    ) {
        for (int offset = 0; offset < length / 2; offset++) {
            if (board[row][start + offset]
                    != board[row][start + length - 1 - offset]) return false;
        }

        return true;
    }

    private static boolean vertical(
            char[][] board,
            int col,
            int start,
            int length
    ) {
        for (int offset = 0; offset < length / 2; offset++) {
            if (board[start + offset][col]
                    != board[start + length - 1 - offset][col]) return false;
        }

        return true;
    }
}
