class Solution {
    /*
     * dp[start][end]에 start부터 end 행렬까지 곱하는 최소 연산 수를 저장한다.
     * 모든 분할 위치의 왼쪽·오른쪽 비용과 마지막 곱셈 비용을 비교한다.
     */
    public int solution(int[][] matrix_sizes) {
        int count = matrix_sizes.length;
        long[][] dp = new long[count][count];

        for (int length = 2; length <= count; length++) {
            for (int start = 0; start + length - 1 < count; start++) {
                int end = start + length - 1;
                dp[start][end] = Long.MAX_VALUE;

                for (int split = start; split < end; split++) {
                    long cost = dp[start][split]
                            + dp[split + 1][end]
                            + (long) matrix_sizes[start][0]
                            * matrix_sizes[split][1]
                            * matrix_sizes[end][1];

                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return (int) dp[0][count - 1];
    }
}
