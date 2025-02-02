import java.util.*;

class Solution {
    /*
     * 단어에 포함된 문자 집합을 비트마스크로 표현한다.
     * 같은 마스크가 이전에 나온 횟수만큼 새로운 유사 단어 쌍이 만들어진다.
     */
    public int similarPairs(String[] words) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (String word : words) {
            int mask = 0;

            for (char ch : word.toCharArray()) mask |= 1 << (ch - 'a');

            answer += count.getOrDefault(mask, 0);
            count.put(mask, count.getOrDefault(mask, 0) + 1);
        }

        return answer;
    }
}
