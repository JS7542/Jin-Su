class Solution {
    /*
     * 각 열의 최댓값을 먼저 구한다.
     * 값이 -1인 칸을 해당 열의 최댓값으로 교체한다.
     */
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] max = new int[matrix[0].length];

        for (int column = 0; column < matrix[0].length; column++) {
            for (int[] row : matrix) max[column] = Math.max(max[column], row[column]);
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == -1) matrix[r][c] = max[c];
            }
        }

        return matrix;
    }
}
