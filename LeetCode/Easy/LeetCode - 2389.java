import java.util.*;

class Solution {
    /*
     * nums를 정렬하고 누적합 배열을 만든다.
     * 각 query마다 누적합이 query 이하인 최대 원소 개수를 이분 탐색한다.
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = (left + right) / 2;

                if (nums[mid] <= queries[i]) left = mid + 1;
                else right = mid;
            }

            answer[i] = left;
        }

        return answer;
    }
}
