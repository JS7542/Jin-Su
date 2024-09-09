import java.util.*;

class Solution {
    /*
     * 이름 배열에서 0, 5, 10과 같이 다섯 칸 간격의 원소를 선택한다.
     * 선택한 이름을 순서대로 배열에 담아 반환한다.
     */
    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < names.length; i += 5) answer.add(names[i]);
        return answer.toArray(new String[0]);
    }
}
