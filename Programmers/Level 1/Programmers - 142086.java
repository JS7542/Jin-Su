import java.util.*;

class Solution {
    /*
     * 각 문자의 가장 최근 등장 인덱스를 해시맵에 저장한다.
     * 현재 위치와 이전 위치의 차이를 기록하고 최근 위치를 갱신한다.
     */
    public int[] solution(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            answer[i] = last.containsKey(ch) ? i - last.get(ch) : -1;
            last.put(ch, i);
        }

        return answer;
    }
}
