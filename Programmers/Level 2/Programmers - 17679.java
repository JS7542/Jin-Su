class Solution {
    /*
     * 같은 문자로 이루어진 2×2 블록을 모두 표시한 뒤 한 번에 제거한다.
     * 각 열의 남은 문자를 아래로 내리는 과정을 더 이상 제거할 수 없을 때까지 반복한다.
     */
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int row = 0; row < m; row++) map[row] = board[row].toCharArray();

        int removed = 0;

        while (true) {
            boolean[][] marked = new boolean[m][n];
            int count = 0;

            for (int row = 0; row + 1 < m; row++) {
                for (int col = 0; col + 1 < n; col++) {
                    char value = map[row][col];

                    if (value == 0) continue;

                    if (map[row + 1][col] == value
                            && map[row][col + 1] == value
                            && map[row + 1][col + 1] == value) {
                        marked[row][col] = true;
                        marked[row + 1][col] = true;
                        marked[row][col + 1] = true;
                        marked[row + 1][col + 1] = true;
                    }
                }
            }

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (marked[row][col]) {
                        map[row][col] = 0;
                        count++;
                    }
                }
            }

            if (count == 0) break;

            removed += count;

            for (int col = 0; col < n; col++) {
                int write = m - 1;

                for (int row = m - 1; row >= 0; row--) {
                    if (map[row][col] != 0) {
                        map[write--][col] = map[row][col];
                    }
                }

                while (write >= 0) map[write--][col] = 0;
            }
        }

        return removed;
    }
}
