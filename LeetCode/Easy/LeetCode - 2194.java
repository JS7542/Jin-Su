import java.util.*;

class Solution {
    /*
     * 시작 열부터 끝 열까지, 각 열에서 시작 행부터 끝 행까지 순회한다.
     * 열 문자와 행 문자를 이어 셀 이름을 순서대로 결과에 추가한다.
     */
    public List<String> cellsInRange(String s) {
        List<String> answer = new ArrayList<>();

        for (char column = s.charAt(0); column <= s.charAt(3); column++) {
            for (char row = s.charAt(1); row <= s.charAt(4); row++) {
                answer.add("" + column + row);
            }
        }

        return answer;
    }
}
