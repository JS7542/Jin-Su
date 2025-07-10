import java.io.*;

class Solution {
    /*
     * 모든 돌 위치에서 가로, 세로, 두 대각선 방향으로 연속한 다섯 칸을 확인한다.
     * 범위 안에서 모두 o이면 오목이 존재한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {0, 1, 1, 1};
        int[] dc = {1, 0, 1, -1};

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[][] board = new char[n][];

            for (int row = 0; row < n; row++) {
                board[row] = br.readLine().toCharArray();
            }

            boolean found = false;

            for (int row = 0; row < n && !found; row++) {
                for (int col = 0; col < n && !found; col++) {
                    if (board[row][col] != 'o') continue;

                    for (int direction = 0; direction < 4; direction++) {
                        int endRow = row + dr[direction] * 4;
                        int endCol = col + dc[direction] * 4;

                        if (endRow < 0 || endRow >= n || endCol < 0 || endCol >= n) continue;

                        boolean five = true;

                        for (int step = 1; step < 5; step++) {
                            if (board[row + dr[direction] * step][col + dc[direction] * step] != 'o') {
                                five = false;
                                break;
                            }
                        }

                        if (five) {
                            found = true;
                            break;
                        }
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(found ? "YES" : "NO").append('\n');
        }

        System.out.print(output);
    }
}
