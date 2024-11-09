import java.util.*;

class Solution {
    /*
     * 각 행의 최솟값을 찾고 해당 값이 위치한 열의 최댓값인지 확인한다.
     * 두 조건을 모두 만족하는 값을 결과 리스트에 추가한다.
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            int minCol = 0;

            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] < matrix[r][minCol]) minCol = c;
            }

            boolean largest = true;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][minCol] > matrix[r][minCol]) {
                    largest = false;
                    break;
                }
            }

            if (largest) answer.add(matrix[r][minCol]);
        }

        return answer;
    }
}
