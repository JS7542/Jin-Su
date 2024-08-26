class Solution {
    /*
     * 배열이 감소하지 않는지와 증가하지 않는지를 동시에 추적한다.
     * 둘 중 하나라도 끝까지 유지되면 단조 배열이다.
     */
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) increasing = false;
            if (nums[i] > nums[i - 1]) decreasing = false;
        }

        return increasing || decreasing;
    }
}
