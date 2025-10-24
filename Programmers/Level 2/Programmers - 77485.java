class Solution {
    /*
     * 각 쿼리의 직사각형 테두리를 한 칸씩 시계 방향으로 이동한다.
     * 이동 중 만난 값의 최솟값을 기록해 결과 배열에 저장한다.
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int value = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) matrix[r][c] = value++;
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int top = queries[q][0] - 1;
            int left = queries[q][1] - 1;
            int bottom = queries[q][2] - 1;
            int right = queries[q][3] - 1;

            int saved = matrix[top][left];
            int minimum = saved;

            for (int r = top; r < bottom; r++) {
                matrix[r][left] = matrix[r + 1][left];
                minimum = Math.min(minimum, matrix[r][left]);
            }

            for (int c = left; c < right; c++) {
                matrix[bottom][c] = matrix[bottom][c + 1];
                minimum = Math.min(minimum, matrix[bottom][c]);
            }

            for (int r = bottom; r > top; r--) {
                matrix[r][right] = matrix[r - 1][right];
                minimum = Math.min(minimum, matrix[r][right]);
            }

            for (int c = right; c > left + 1; c--) {
                matrix[top][c] = matrix[top][c - 1];
                minimum = Math.min(minimum, matrix[top][c]);
            }

            matrix[top][left + 1] = saved;
            answer[q] = minimum;
        }

        return answer;
    }
}
