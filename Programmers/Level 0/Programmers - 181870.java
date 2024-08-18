import java.util.*;

class Solution {
    /*
     * 문자열 배열을 순회하며 ad가 포함되지 않은 문자열만 선택한다.
     * 선택된 문자열을 기존 순서대로 배열에 담아 반환한다.
     */
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
                .filter(text -> !text.contains("ad"))
                .toArray(String[]::new);
    }
}
