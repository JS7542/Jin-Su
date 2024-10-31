import java.util.*;

class Solution {
    /*
     * 점수를 오름차순으로 정렬한다.
     * 길이 k인 모든 연속 구간에서 마지막 값과 첫 값의 차이 최솟값을 구한다.
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;

        for (int start = 0; start + k <= nums.length; start++) {
            answer = Math.min(answer, nums[start + k - 1] - nums[start]);
        }

        return answer;
    }
}
