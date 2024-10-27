import java.util.*;

class Solution {
    /*
     * 같은 숫자가 세 번 이상 등장하면 두 배열에 중복 없이 나눌 수 없다.
     * 모든 숫자의 빈도가 2 이하인지 확인한다.
     */
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int number : nums) {
            int frequency = count.getOrDefault(number, 0) + 1;
            if (frequency > 2) return false;
            count.put(number, frequency);
        }

        return true;
    }
}
