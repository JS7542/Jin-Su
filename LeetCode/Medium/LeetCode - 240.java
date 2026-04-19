class Solution {
    /*
     * 오른쪽 위 칸에서 시작한다.
     * 현재 값이 target보다 크면 왼쪽, 작으면 아래로 이동해 한 행이나 한 열을 제거한다.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (value == target) return true;

            if (value > target) col--;
            else row++;
        }

        return false;
    }
}
