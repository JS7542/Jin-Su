import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 현재 시작 위치부터 원소를 선택한다.
     * 같은 깊이에서 이전과 같은 값은 건너뛰어 중복 부분집합을 제거한다.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            int[] nums,
            int start,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        answer.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            build(nums, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
