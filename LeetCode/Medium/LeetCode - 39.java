import java.util.*;

class Solution {
    /*
     * 후보를 오름차순 정렬하고 현재 인덱스부터 수를 선택한다.
     * 같은 수를 다시 사용할 수 있도록 선택 후에도 같은 인덱스에서 탐색한다.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void search(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        if (remaining == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;

            current.add(candidates[i]);
            search(candidates, remaining - candidates[i], i, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
