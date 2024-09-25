import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 양 끝 값을 하나씩 짝지어 평균을 계산한다.
     * 모든 짝의 평균 중 최솟값을 반환한다.
     */
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double answer = Double.MAX_VALUE;

        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            answer = Math.min(answer, (nums[left] + nums[right]) / 2.0);
        }

        return answer;
    }
}
