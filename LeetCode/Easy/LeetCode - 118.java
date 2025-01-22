import java.util.*;

class Solution {
    /*
     * 각 행의 양 끝을 1로 두고 내부 값은 바로 위 행의 두 값을 더한다.
     * 첫 행부터 numRows개의 행을 차례대로 리스트에 저장한다.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for (int col = 1; col < row; col++) {
                current.add(triangle.get(row - 1).get(col - 1)
                        + triangle.get(row - 1).get(col));
            }

            if (row > 0) current.add(1);
            triangle.add(current);
        }

        return triangle;
    }
}
