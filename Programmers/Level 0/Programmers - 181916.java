import java.util.*;

class Solution {
    /*
     * 네 주사위 숫자의 빈도수를 세어 같은 숫자 개수에 따라 경우를 구분한다.
     * 문제에서 정한 점수 공식을 각 빈도 패턴에 맞게 적용한다.
     */
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Map<Integer, Integer> count = new HashMap<>();

        for (int value : dice) count.put(value, count.getOrDefault(value, 0) + 1);

        if (count.size() == 1) return 1111 * a;

        if (count.size() == 2) {
            int firstValue = 0;
            int secondValue = 0;
            int firstCount = 0;

            for (int value : count.keySet()) {
                if (firstCount == 0) {
                    firstValue = value;
                    firstCount = count.get(value);
                } else {
                    secondValue = value;
                }
            }

            int secondCount = count.get(secondValue);

            if (firstCount == 3 || secondCount == 3) {
                int p = firstCount == 3 ? firstValue : secondValue;
                int q = firstCount == 1 ? firstValue : secondValue;
                return (10 * p + q) * (10 * p + q);
            }

            return (firstValue + secondValue) * Math.abs(firstValue - secondValue);
        }

        if (count.size() == 3) {
            int product = 1;
            for (int value : count.keySet()) {
                if (count.get(value) == 1) product *= value;
            }
            return product;
        }

        int min = a;
        for (int value : dice) min = Math.min(min, value);
        return min;
    }
}
