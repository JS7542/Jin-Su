class Solution {
    /*
     * 각 행에서 주대각선과 부대각선 위치의 값을 더한다.
     * 홀수 크기 행렬의 가운데 값은 중복되므로 한 번 빼준다.
     */
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer += mat[i][i] + mat[i][n - 1 - i];
        }

        if (n % 2 == 1) answer -= mat[n / 2][n / 2];
        return answer;
    }
}
