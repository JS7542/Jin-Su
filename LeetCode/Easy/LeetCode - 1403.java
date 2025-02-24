import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬하고 큰 값부터 선택한다.
     * 선택한 합이 남은 합보다 커지는 순간의 부분 수열을 반환한다.
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int number : nums) total += number;

        List<Integer> answer = new ArrayList<>();
        int selected = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            selected += nums[i];
            answer.add(nums[i]);
            if (selected > total - selected) break;
        }

        return answer;
    }
}
