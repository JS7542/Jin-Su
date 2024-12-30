import java.util.*;

class Solution {
    /*
     * 각 원소의 일차원 인덱스에 k를 더하고 전체 칸 수로 나눈다.
     * 이동한 인덱스를 새 행과 열로 변환해 결과 리스트를 만든다.
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;
        int[][] shifted = new int[rows][cols];

        for (int index = 0; index < total; index++) {
            int next = (index + k) % total;
            shifted[next / cols][next % cols] = grid[index / cols][index % cols];
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int[] row : shifted) {
            List<Integer> values = new ArrayList<>();
            for (int value : row) values.add(value);
            answer.add(values);
        }
        return answer;
    }
}
