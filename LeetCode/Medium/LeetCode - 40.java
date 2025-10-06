import java.util.*;

class Solution {
    /*
     * 후보 배열을 정렬하고 각 숫자를 한 번만 사용하며 백트래킹한다.
     * 같은 깊이의 같은 값은 건너뛰어 중복 조합을 제거한다.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > remaining) break;

            current.add(candidates[i]);
            search(candidates, remaining - candidates[i], i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
