import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬한다.
     * 가장 큰 두 수의 곱에서 가장 작은 두 수의 곱을 뺀다.
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
