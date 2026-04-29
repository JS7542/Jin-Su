class Solution {
    /*
     * dp[n]은 n개 값으로 만들 수 있는 서로 다른 BST 개수다.
     * 각 값을 루트로 선택했을 때 왼쪽과 오른쪽 경우의 수 곱을 모두 더한다.
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        return dp[n];
    }
}
