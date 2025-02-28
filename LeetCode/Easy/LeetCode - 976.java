import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬하고 큰 세 변부터 확인한다.
     * 작은 두 변의 합이 가장 큰 변보다 큰 첫 조합의 둘레가 최대다.
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }
}
