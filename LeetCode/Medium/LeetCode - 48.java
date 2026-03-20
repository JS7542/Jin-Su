class Solution {
    /*
     * 정사각 행렬을 주대각선 기준으로 전치한다.
     * 각 행을 좌우로 뒤집으면 시계 방향 90도 회전이 완성된다.
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int[] row : matrix) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = row[left];
                row[left++] = row[right];
                row[right--] = temp;
            }
        }
    }
}
