class Solution {
    /*
     * 첫 행과 첫 열을 제외한 각 셀을 왼쪽 위 대각선 셀과 비교한다.
     * 하나라도 값이 다르면 Toeplitz 행렬이 아니다.
     */
    public boolean isToeplitzMatrix(int[][] matrix){for(int r=1;r<matrix.length;r++)for(int c=1;c<matrix[0].length;c++)if(matrix[r][c]!=matrix[r-1][c-1])return false;return true;}
}
