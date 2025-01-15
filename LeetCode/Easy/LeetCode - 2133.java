class Solution {
    /*
     * 각 행과 열에서 1부터 n까지 숫자가 중복 없이 등장하는지 확인한다.
     * 중복이 하나라도 발생하면 유효한 행렬이 아니다.
     */
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] row = new boolean[n + 1];
            boolean[] col = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                int rowValue = matrix[i][j];
                int colValue = matrix[j][i];

                if (row[rowValue] || col[colValue]) return false;
                row[rowValue] = true;
                col[colValue] = true;
            }
        }

        return true;
    }
}
