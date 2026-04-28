class Solution {
    /*
     * dp[row][col]에 해당 칸을 오른쪽 아래로 하는 가장 큰 정사각형 변 길이를 저장한다.
     * 값이 1이면 위·왼쪽·왼쪽 위 값의 최솟값에 1을 더한다.
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maximum = 0;

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = Math.min(
                            dp[row - 1][col],
                            Math.min(dp[row][col - 1], dp[row - 1][col - 1])
                    ) + 1;

                    maximum = Math.max(maximum, dp[row][col]);
                }
            }
        }

        return maximum * maximum;
    }
}
