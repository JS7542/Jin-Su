import java.util.*;

class Solution {
    /*
     * 단어를 사전순으로 정렬하면 구분에 필요한 접두사 길이는 양옆 단어만 보면 된다.
     * 이전·다음 단어와의 공통 접두사 최댓값에 1을 더하되 단어 길이를 넘지 않는다.
     */
    public int solution(String[] words) {
        Arrays.sort(words);
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            int previous = i > 0 ? common(words[i], words[i - 1]) : 0;
            int next = i + 1 < words.length ? common(words[i], words[i + 1]) : 0;

            answer += Math.min(
                    words[i].length(),
                    Math.max(previous, next) + 1
            );
        }

        return answer;
    }

    private int common(String first, String second) {
        int length = Math.min(first.length(), second.length());
        int index = 0;

        while (index < length && first.charAt(index) == second.charAt(index)) {
            index++;
        }

        return index;
    }
}
