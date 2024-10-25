import java.util.*;

class Solution {
    /*
     * 각 문자열을 separator 기준으로 나눈다.
     * 빈 문자열을 제외한 모든 조각을 입력 순서대로 결과에 추가한다.
     */
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> answer = new ArrayList<>();
        String regex = java.util.regex.Pattern.quote(String.valueOf(separator));

        for (String word : words) {
            for (String part : word.split(regex, -1)) {
                if (!part.isEmpty()) answer.add(part);
            }
        }

        return answer;
    }
}
