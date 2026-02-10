import java.util.*;

class Solution {
    /*
     * 1부터 9까지 숫자 중 K개를 고르는 조합을 백트래킹한다.
     * 선택한 숫자 합이 N이 되는 조합만 결과에 추가한다.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        search(1, k, n, new ArrayList<>(), answer);
        return answer;
    }

    private void search(
            int start,
            int remainingCount,
            int remainingSum,
            List<Integer> current,
            List<List<Integer>> answer
    ) {
        if (remainingCount == 0) {
            if (remainingSum == 0) answer.add(new ArrayList<>(current));
            return;
        }

        for (int number = start; number <= 9; number++) {
            if (number > remainingSum) break;

            current.add(number);
            search(
                    number + 1,
                    remainingCount - 1,
                    remainingSum - number,
                    current,
                    answer
            );
            current.remove(current.size() - 1);
        }
    }
}
