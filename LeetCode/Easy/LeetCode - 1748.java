import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 횟수를 해시맵에 저장한다.
     * 정확히 한 번 등장한 숫자만 합산해 반환한다.
     */
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) count.put(number, count.getOrDefault(number, 0) + 1);

        int answer = 0;
        for (int number : count.keySet()) {
            if (count.get(number) == 1) answer += number;
        }
        return answer;
    }
}
