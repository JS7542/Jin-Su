import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 사용 여부를 추적하며 순열을 만든다.
     * 같은 값의 앞 원소를 사용하지 않은 상태에서는 현재 중복 값을 건너뛴다.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);
            build(nums, used, current, answer);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
