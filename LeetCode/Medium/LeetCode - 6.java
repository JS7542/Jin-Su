import java.util.*;

class Solution {
    /*
     * 각 행에 해당하는 StringBuilder를 준비한다.
     * 행 인덱스를 위아래로 왕복하며 문자를 배치한 뒤 모든 행을 이어 붙인다.
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());

        int row = 0;
        int direction = 1;

        for (char ch : s.toCharArray()) {
            rows.get(row).append(ch);

            if (row == 0) direction = 1;
            else if (row == numRows - 1) direction = -1;

            row += direction;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder current : rows) answer.append(current);
        return answer.toString();
    }
}
