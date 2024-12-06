import java.util.*;

class Solution {
    /*
     * 각 숫자의 빈도수를 센다.
     * 빈도수의 절반은 만들 수 있는 쌍, 나머지는 남는 원소 수에 더한다.
     */
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) count.put(number, count.getOrDefault(number, 0) + 1);

        int pairs = 0;
        int leftover = 0;

        for (int frequency : count.values()) {
            pairs += frequency / 2;
            leftover += frequency % 2;
        }

        return new int[]{pairs, leftover};
    }
}
