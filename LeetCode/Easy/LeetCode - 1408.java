import java.util.*;

class Solution {
    /*
     * 각 문자열이 다른 문자열 내부에 포함되는지 모든 쌍을 비교한다.
     * 하나라도 포함되는 문자열을 결과 리스트에 추가한다.
     */
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }

        return answer;
    }
}
