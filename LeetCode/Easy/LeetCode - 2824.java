import java.util.*;

class Solution {
    /*
     * 리스트를 오름차순으로 정렬하고 양 끝 포인터를 사용한다.
     * 합이 target보다 작으면 왼쪽 값과 만들 수 있는 모든 오른쪽 쌍을 센다.
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int answer = 0;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                answer += right - left;
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
