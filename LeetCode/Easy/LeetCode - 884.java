import java.util.*;

class Solution {
    /*
     * 두 문장의 모든 단어를 하나의 해시맵에서 빈도수로 센다.
     * 전체에서 정확히 한 번 등장한 단어만 결과 배열로 반환한다.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();

        for (String word : (s1 + " " + s2).split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> answer = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) answer.add(word);
        }

        return answer.toArray(new String[0]);
    }
}
