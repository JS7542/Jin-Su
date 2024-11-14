class Solution {
    /*
     * 각 원소를 포함하는 경우와 포함하지 않는 경우를 재귀적으로 탐색한다.
     * 모든 부분집합의 XOR 값을 합산해 반환한다.
     */
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xor) {
        if (index == nums.length) return xor;
        return dfs(nums, index + 1, xor)
                + dfs(nums, index + 1, xor ^ nums[index]);
    }
}
