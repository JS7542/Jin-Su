import java.util.*;

class Solution {
    /*
     * 이전에 나온 단어를 해시셋에 저장한다.
     * 현재 단어를 뒤집은 문자열이 집합에 있으면 한 쌍을 찾은 것이다.
     */
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> seen = new HashSet<>();
        int answer = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (seen.contains(reversed)) answer++;
            else seen.add(word);
        }

        return answer;
    }
}
