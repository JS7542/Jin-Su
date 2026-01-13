class Solution {
    /*
     * 현재까지 도달 가능한 가장 먼 인덱스를 유지한다.
     * 현재 위치가 그 범위를 벗어나면 실패하고, 마지막까지 확인하면 성공한다.
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}
