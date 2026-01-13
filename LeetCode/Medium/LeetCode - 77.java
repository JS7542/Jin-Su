import java.util.*;

class Solution {
    /*
     * 현재 숫자부터 n까지 하나씩 선택하며 조합을 만든다.
     * 선택한 수가 k개가 되면 현재 조합을 결과에 복사한다.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        build(n, k, 1, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            int n,
            int k,
            int start,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        int needed = k - current.size();

        for (int value = start; value <= n - needed + 1; value++) {
            current.add(value);
            build(n, k, value + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
