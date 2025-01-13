import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬한다.
     * 인접한 두 값을 서로 바꿔 Bob의 값, Alice의 값 순으로 결과를 만든다.
     */
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }
}
