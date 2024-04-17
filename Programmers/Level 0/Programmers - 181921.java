import java.util.*;

class Solution {
    /*
     * l부터 r까지의 각 숫자가 0과 5로만 이루어졌는지 확인한다.
     * 조건을 만족하는 수를 모으고 없으면 -1 배열을 반환한다.
     */
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();

        for (int value = l; value <= r; value++) {
            if (onlyZeroAndFive(value)) answer.add(value);
        }

        return answer.isEmpty()
                ? new int[]{-1}
                : answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean onlyZeroAndFive(int value) {
        while (value > 0) {
            int digit = value % 10;
            if (digit != 0 && digit != 5) return false;
            value /= 10;
        }
        return true;
    }
}
