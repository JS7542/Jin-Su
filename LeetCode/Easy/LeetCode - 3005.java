import java.util.*;

class Solution {
    /*
     * 각 숫자의 빈도수를 세며 최대 빈도를 구한다.
     * 최대 빈도를 가진 숫자들의 빈도 합을 반환한다.
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;

        for (int number : nums) {
            int frequency = count.getOrDefault(number, 0) + 1;
            count.put(number, frequency);
            max = Math.max(max, frequency);
        }

        int answer = 0;

        for (int frequency : count.values()) {
            if (frequency == max) answer += frequency;
        }

        return answer;
    }
}
