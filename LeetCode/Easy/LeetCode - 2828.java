import java.util.*;

class Solution {
    /*
     * 단어 수와 약어 문자열 길이가 같은지 확인한다.
     * 각 단어의 첫 문자가 약어의 같은 위치 문자와 같은지 비교한다.
     */
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }

        return true;
    }
}
