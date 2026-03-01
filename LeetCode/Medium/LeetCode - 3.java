import java.util.*;

class Solution {
    /*
     * 각 문자의 가장 최근 위치를 기록한다.
     * 중복 문자를 만나면 왼쪽 경계를 이전 위치 다음으로 이동시킨다.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (last.containsKey(ch)) {
                left = Math.max(left, last.get(ch) + 1);
            }

            last.put(ch, right);
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
