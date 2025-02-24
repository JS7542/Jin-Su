import java.util.*;

class Solution {
    /*
     * key 바로 다음에 등장하는 숫자의 빈도수를 센다.
     * 가장 높은 빈도를 가진 숫자를 반환한다.
     */
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        int best = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] != key) continue;

            int target = nums[i + 1];
            int frequency = count.getOrDefault(target, 0) + 1;
            count.put(target, frequency);

            if (frequency > best) {
                best = frequency;
                answer = target;
            }
        }

        return answer;
    }
}
