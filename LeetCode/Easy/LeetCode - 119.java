import java.util.*;

class Solution {
    /*
     * 한 행의 리스트를 유지하며 뒤쪽부터 값을 갱신한다.
     * 뒤에서 계산하면 아직 필요한 이전 행의 값이 덮어쓰이지 않는다.
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }
}
