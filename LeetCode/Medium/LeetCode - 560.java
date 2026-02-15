import java.util.*;

class Solution {
    /*
     * 현재까지의 누적합과 이전 누적합 빈도를 해시맵에 저장한다.
     * current-k가 이전에 등장한 횟수만큼 합이 k인 부분배열이 존재한다.
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);

        int prefix = 0;
        int answer = 0;

        for (int number : nums) {
            prefix += number;
            answer += frequency.getOrDefault(prefix - k, 0);
            frequency.put(prefix, frequency.getOrDefault(prefix, 0) + 1);
        }

        return answer;
    }
}
