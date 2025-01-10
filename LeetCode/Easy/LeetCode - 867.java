class Solution {
    /*
     * 원본 행렬의 행과 열 크기를 바꾼 새 행렬을 만든다.
     * 원본의 matrix[r][c]를 새 행렬의 answer[c][r]에 저장한다.
     */
    public int[][] transpose(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                answer[c][r] = matrix[r][c];
            }
        }

        return answer;
    }
}
