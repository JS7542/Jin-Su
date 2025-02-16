import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬한다.
     * target과 같은 값이 있는 모든 인덱스를 결과 리스트에 추가한다.
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) answer.add(i);
        }

        return answer;
    }
}
