import java.util.*;

class Solution {
    /*
     * 삭제할 인덱스를 boolean 배열에 표시한다.
     * 표시되지 않은 문자만 순서대로 이어 붙여 반환한다.
     */
    public String solution(String my_string, int[] indices) {
        boolean[] deleted = new boolean[my_string.length()];
        for (int index : indices) deleted[index] = true;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!deleted[i]) answer.append(my_string.charAt(i));
        }

        return answer.toString();
    }
}
