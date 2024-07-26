import java.util.*;

class Solution {
    /*
     * 각 문자를 알파벳 순서로 이동하되 skip에 포함된 문자는 이동 횟수에서 제외한다.
     * index번의 유효한 이동을 마친 문자를 결과에 추가한다.
     */
    public String solution(String s, String skip, int index) {
        Set<Character> skipped = new HashSet<>();
        for (char ch : skip.toCharArray()) skipped.add(ch);

        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int moved = 0;

            while (moved < index) {
                ch = (char) ('a' + (ch - 'a' + 1) % 26);
                if (!skipped.contains(ch)) moved++;
            }

            answer.append(ch);
        }

        return answer.toString();
    }
}
