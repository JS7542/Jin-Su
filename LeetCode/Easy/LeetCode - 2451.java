import java.util.*;

class Solution {
    /*
     * 각 단어에서 인접 문자 차이 배열을 문자열 키로 만든다.
     * 한 번만 등장하는 차이 패턴을 가진 원래 단어를 반환한다.
     */
    public String oddString(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, String> sample = new HashMap<>();

        for (String word : words) {
            String key = pattern(word);
            count.put(key, count.getOrDefault(key, 0) + 1);
            sample.put(key, word);
        }

        for (String key : count.keySet()) {
            if (count.get(key) == 1) return sample.get(key);
        }

        return "";
    }

    private String pattern(String word) {
        StringBuilder key = new StringBuilder();

        for (int i = 1; i < word.length(); i++) {
            key.append(word.charAt(i) - word.charAt(i - 1)).append(',');
        }

        return key.toString();
    }
}
