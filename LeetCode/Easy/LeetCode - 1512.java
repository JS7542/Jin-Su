import java.util.*;

class Solution {
    /*
     * 각 숫자를 만나기 전에 같은 숫자가 등장한 횟수를 결과에 더한다.
     * 이후 현재 숫자의 빈도수를 하나 증가시킨다.
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (int number : nums) {
            answer += count.getOrDefault(number, 0);
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        return answer;
    }
}
