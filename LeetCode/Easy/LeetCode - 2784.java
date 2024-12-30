import java.util.*;

class Solution {
    /*
     * 좋은 배열은 1부터 n-1까지 한 번씩, n-1은 두 번 등장한다.
     * 정렬 후 각 위치가 요구되는 값과 같은지 확인한다.
     */
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            int expected = Math.min(i + 1, n);
            if (nums[i] != expected) return false;
        }

        return true;
    }
}
