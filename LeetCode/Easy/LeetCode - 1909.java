class Solution {
    /*
     * 각 인덱스를 하나씩 제거했다고 가정하고 나머지 배열이 엄격히 증가하는지 확인한다.
     * 가능한 제거 위치가 하나라도 있으면 true를 반환한다.
     */
    public boolean canBeIncreasing(int[] nums) {
        for (int removed = 0; removed < nums.length; removed++) {
            int previous = Integer.MIN_VALUE;
            boolean valid = true;

            for (int i = 0; i < nums.length; i++) {
                if (i == removed) continue;

                if (nums[i] <= previous) {
                    valid = false;
                    break;
                }
                previous = nums[i];
            }

            if (valid) return true;
        }

        return false;
    }
}
