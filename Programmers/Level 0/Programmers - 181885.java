import java.util.*;

class Solution {
    /*
     * finished가 false인 위치의 할 일만 선택한다.
     * 선택한 문자열을 기존 순서대로 배열로 반환한다.
     */
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) answer.add(todo_list[i]);
        }

        return answer.toArray(new String[0]);
    }
}
