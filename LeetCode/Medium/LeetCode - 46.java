import java.util.*;

class Solution {
    /*
     * 각 위치에서 아직 사용하지 않은 숫자를 하나 선택한다.
     * 모든 숫자를 선택하면 현재 순열을 결과에 복사한다.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        build(nums, used, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);
            build(nums, used, current, answer);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
