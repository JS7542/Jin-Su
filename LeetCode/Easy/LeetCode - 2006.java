import java.util.*;

class Solution {
    /*
     * 현재 숫자와 차이가 k인 이전 숫자의 빈도수를 결과에 더한다.
     * 현재 숫자를 해시맵에 저장한 뒤 다음 원소로 이동한다.
     */
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (int number : nums) {
            answer += count.getOrDefault(number - k, 0);
            answer += count.getOrDefault(number + k, 0);
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        return answer;
    }
}
