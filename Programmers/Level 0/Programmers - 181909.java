import java.util.*;

class Solution {
    /*
     * 문자열의 각 시작 위치부터 끝까지의 접미사를 배열에 저장한다.
     * 모든 접미사를 사전순으로 정렬해 반환한다.
     */
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);
        }

        Arrays.sort(answer);
        return answer;
    }
}
