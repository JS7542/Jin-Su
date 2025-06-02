import java.util.*;

class Solution {
    /*
     * 각 질문의 비동의·동의 선택에 따라 두 성격 지표 중 하나에 점수를 더한다.
     * 네 지표 쌍마다 점수가 높은 유형을 선택하고 동점이면 사전순 앞 유형을 고른다.
     */
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                score.put(disagree, score.getOrDefault(disagree, 0) + 4 - choice);
            } else if (choice > 4) {
                score.put(agree, score.getOrDefault(agree, 0) + choice - 4);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (String pair : new String[]{"RT", "CF", "JM", "AN"}) {
            char first = pair.charAt(0);
            char second = pair.charAt(1);

            answer.append(
                    score.getOrDefault(first, 0) >= score.getOrDefault(second, 0)
                            ? first : second
            );
        }

        return answer.toString();
    }
}
