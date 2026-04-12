import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 첫 값을 고정한 뒤 양 끝 포인터로 나머지 두 값을 찾는다.
     * target과의 차이가 가장 작은 합을 계속 갱신한다.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - answer)) {
                    answer = sum;
                }

                if (sum < target) left++;
                else if (sum > target) right--;
                else return target;
            }
        }

        return answer;
    }
}
