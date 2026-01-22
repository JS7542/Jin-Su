import java.util.*;

class Solution {
    /*
     * 열 조합을 비트마스크로 순회한다.
     * 이미 선택된 후보키를 포함하지 않는 조합 중 모든 행을 유일하게 구분하는 조합만 후보키로 저장한다.
     */
    public int solution(String[][] relation) {
        int columns = relation[0].length;
        List<Integer> keys = new ArrayList<>();

        for (int mask = 1; mask < (1 << columns); mask++) {
            boolean minimal = true;

            for (int key : keys) {
                if ((mask & key) == key) {
                    minimal = false;
                    break;
                }
            }

            if (!minimal) continue;

            Set<String> rows = new HashSet<>();

            for (String[] row : relation) {
                StringBuilder value = new StringBuilder();

                for (int column = 0; column < columns; column++) {
                    if ((mask & (1 << column)) != 0) {
                        value.append(row[column].length())
                                .append(':').append(row[column]).append('|');
                    }
                }

                rows.add(value.toString());
            }

            if (rows.size() == relation.length) keys.add(mask);
        }

        return keys.size();
    }
}
