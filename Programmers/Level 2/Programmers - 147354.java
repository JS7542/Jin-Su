import java.util.*;

class Solution {
    /*
     * col번째 값 오름차순, 기본키 내림차순으로 행을 정렬한다.
     * row_begin부터 row_end까지 각 행의 나머지 합을 구해 XOR 누적한다.
     */
    public int solution(
            int[][] data,
            int col,
            int row_begin,
            int row_end
    ) {
        int column = col - 1;

        Arrays.sort(data, (first, second) -> {
            int compare = Integer.compare(
                    first[column],
                    second[column]
            );

            return compare != 0
                    ? compare
                    : Integer.compare(second[0], first[0]);
        });

        int answer = 0;

        for (int row = row_begin; row <= row_end; row++) {
            int sum = 0;

            for (int value : data[row - 1]) sum += value % row;

            answer ^= sum;
        }

        return answer;
    }
}
