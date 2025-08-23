class Solution {
    /*
     * 행렬을 하나의 정렬된 일차원 배열처럼 생각한다.
     * 중간 인덱스를 행과 열로 변환해 이분 탐색한다.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / cols][mid % cols];

            if (value == target) return true;
            if (value < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
