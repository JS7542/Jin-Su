class Solution {
    /*
     * 첫 행과 첫 열을 각 행·열의 0 존재 표시 공간으로 사용한다.
     * 원래 첫 행·열의 0 여부는 별도 변수로 저장한 뒤 마지막에 처리한다.
     */
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) firstRowZero = true;
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) firstColZero = true;
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int col = 0; col < matrix[0].length; col++) matrix[0][col] = 0;
        }

        if (firstColZero) {
            for (int row = 0; row < matrix.length; row++) matrix[row][0] = 0;
        }
    }
}
