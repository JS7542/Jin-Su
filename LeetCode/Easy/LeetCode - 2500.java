import java.util.*;

class Solution {
    /*
     * 각 행을 오름차순으로 정렬한다.
     * 같은 열 위치의 값 중 최댓값을 골라 모든 열에 대해 합산한다.
     */
    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) Arrays.sort(row);

        int answer = 0;

        for (int column = 0; column < grid[0].length; column++) {
            int max = 0;

            for (int[] row : grid) max = Math.max(max, row[column]);

            answer += max;
        }

        return answer;
    }
}
