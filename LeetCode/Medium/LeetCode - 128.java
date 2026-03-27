import java.util.*;

class Solution {
    /*
     * 모든 값을 해시셋에 저장한다.
     * 이전 값이 없는 숫자만 연속 수열의 시작으로 보고 길이를 확장한다.
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int number : nums) values.add(number);

        int answer = 0;

        for (int number : values) {
            if (values.contains(number - 1)) continue;

            int current = number;
            int length = 1;

            while (values.contains(current + 1)) {
                current++;
                length++;
            }

            answer = Math.max(answer, length);
        }

        return answer;
    }
}
