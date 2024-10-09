import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 횟수를 해시맵에 저장한다.
     * 모든 빈도수가 짝수이면 같은 숫자 두 개씩 쌍을 만들 수 있다.
     */
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) count.put(number, count.getOrDefault(number, 0) + 1);

        for (int frequency : count.values()) {
            if (frequency % 2 == 1) return false;
        }

        return true;
    }
}
