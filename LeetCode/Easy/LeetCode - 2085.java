import java.util.*;

class Solution {
    /*
     * 두 문자열 배열의 단어 빈도수를 각각 해시맵에 저장한다.
     * 양쪽 배열에서 모두 정확히 한 번 등장한 단어의 개수를 센다.
     */
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> first = count(words1);
        Map<String, Integer> second = count(words2);
        int answer = 0;

        for (String word : first.keySet()) {
            if (first.get(word) == 1 && second.getOrDefault(word, 0) == 1) answer++;
        }

        return answer;
    }

    private Map<String, Integer> count(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) count.put(word, count.getOrDefault(word, 0) + 1);
        return count;
    }
}
