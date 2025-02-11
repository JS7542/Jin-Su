import java.util.*;

class Solution {
    /*
     * 모든 숫자를 해시셋에 저장한다.
     * 양수 k와 -k가 모두 존재하는 값 중 가장 큰 k를 반환한다.
     */
    public int findMaxK(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int number : nums) values.add(number);

        int answer = -1;

        for (int number : nums) {
            if (number > 0 && values.contains(-number)) answer = Math.max(answer, number);
        }

        return answer;
    }
}
