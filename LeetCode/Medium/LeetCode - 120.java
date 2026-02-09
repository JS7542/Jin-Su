import java.util.*;

class Solution {
    /*
     * 삼각형의 마지막 행을 DP 초기값으로 사용한다.
     * 아래에서 위로 올라가며 두 자식 경로 중 작은 값에 현재 값을 더한다.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        for (int i = 0; i < size; i++) {
            dp[i] = triangle.get(size - 1).get(i);
        }

        for (int row = size - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col)
                        + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
}
