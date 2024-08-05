import java.util.*;

class Solution {
    /*
     * 알파벳 순서에 대응하는 모스부호 배열을 준비한다.
     * 공백으로 분리된 각 부호의 인덱스를 찾아 알파벳으로 변환한다.
     */
    public String solution(String letter) {
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < morse.length; i++) map.put(morse[i], (char) ('a' + i));

        StringBuilder sb = new StringBuilder();
        for (String code : letter.split(" ")) sb.append(map.get(code));
        return sb.toString();
    }
}
