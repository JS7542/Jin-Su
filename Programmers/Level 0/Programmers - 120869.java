import java.util.*;

class Solution {
    /*
     * spell의 문자들을 정렬한 기준 문자열을 만든다.
     * 사전 단어 중 같은 길이이며 정렬 결과가 기준과 같으면 1을 반환한다.
     */
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String target = String.join("", spell);

        for (String word : dic) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            if (new String(chars).equals(target)) return 1;
        }

        return 2;
    }
}
