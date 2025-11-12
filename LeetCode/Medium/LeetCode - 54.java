import java.util.*;

class Solution {
    /*
     * 위, 아래, 왼쪽, 오른쪽 경계를 유지한다.
     * 네 방향을 순서대로 순회한 뒤 사용한 경계를 안쪽으로 줄인다.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) answer.add(matrix[top][col]);
            top++;

            for (int row = top; row <= bottom; row++) answer.add(matrix[row][right]);
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) answer.add(matrix[bottom][col]);
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) answer.add(matrix[row][left]);
                left++;
            }
        }

        return answer;
    }
}
