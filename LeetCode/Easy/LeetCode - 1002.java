import java.util.*;

class Solution {
    /*
     * 공통 알파벳 빈도를 첫 단어의 빈도로 초기화한다.
     * 각 단어의 빈도와 위치별 최솟값을 유지해 모든 단어에 공통인 문자를 구한다.
     */
    public List<String> commonChars(String[] words) {
        int[] common = frequency(words[0]);

        for (int i = 1; i < words.length; i++) {
            int[] current = frequency(words[i]);
            for (int letter = 0; letter < 26; letter++) {
                common[letter] = Math.min(common[letter], current[letter]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (int letter = 0; letter < 26; letter++) {
            while (common[letter]-- > 0) answer.add(String.valueOf((char) ('a' + letter)));
        }
        return answer;
    }

    private int[] frequency(String word) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()) count[ch - 'a']++;
        return count;
    }
}
