import java.util.*;

class Solution {
    /*
     * 로마 숫자를 왼쪽부터 읽으며 현재 값이 다음 값보다 작으면 뺄셈 규칙을 적용한다.
     * 그 외에는 현재 값을 더해 전체 정수를 계산한다.
     */
    public int romanToInt(String s) {
        Map<Character, Integer> value = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000
        );

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = value.get(s.charAt(i));
            if (i + 1 < s.length() && current < value.get(s.charAt(i + 1))) answer -= current;
            else answer += current;
        }

        return answer;
    }
}
