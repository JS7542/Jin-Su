import java.util.*;

class Solution {
    /*
     * x 문자를 하나 이상의 구분자로 사용해 문자열을 나눈다.
     * 빈 문자열을 제외한 결과를 사전순으로 정렬해 반환한다.
     */
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x+"))
                .filter(text -> !text.isEmpty())
                .sorted()
                .toArray(String[]::new);
    }
}
