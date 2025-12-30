class Solution {
    /*
     * 각 행에 퀸을 하나씩 놓으며 열과 두 대각선 사용 여부를 확인한다.
     * 가능한 위치에 배치하고 되돌리는 백트래킹으로 전체 경우를 센다.
     */
    private boolean[] columns;
    private boolean[] diagonalDown;
    private boolean[] diagonalUp;
    private int answer;

    public int solution(int n) {
        columns = new boolean[n];
        diagonalDown = new boolean[n * 2];
        diagonalUp = new boolean[n * 2];

        place(0, n);
        return answer;
    }

    private void place(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int down = row - col + n;
            int up = row + col;

            if (columns[col] || diagonalDown[down] || diagonalUp[up]) continue;

            columns[col] = true;
            diagonalDown[down] = true;
            diagonalUp[up] = true;

            place(row + 1, n);

            columns[col] = false;
            diagonalDown[down] = false;
            diagonalUp[up] = false;
        }
    }
}
