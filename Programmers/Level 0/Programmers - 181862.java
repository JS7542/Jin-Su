import java.util.*;

class Solution {
    /*
     * a, b, c 문자를 구분자로 사용해 문자열을 나눈다.
     * 빈 문자열을 제외하고 사전순으로 정렬하며 결과가 없으면 EMPTY를 반환한다.
     */
    public String[] solution(String myStr) {
        String[] parts = myStr.split("[abc]+");
        List<String> answer = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty()) answer.add(part);
        }

        return answer.isEmpty() ? new String[]{"EMPTY"} : answer.toArray(new String[0]);
    }
}
