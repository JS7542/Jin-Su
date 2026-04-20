import java.util.*;

class Solution {
    /*
     * 각 숫자를 선택하는 경우와 선택하지 않는 경우를 재귀적으로 탐색한다.
     * 배열 끝에 도달하면 현재 부분집합을 결과에 복사한다.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        if (index == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        build(nums, index + 1, current, answer);

        current.add(nums[index]);
        build(nums, index + 1, current, answer);
        current.remove(current.size() - 1);
    }
}
