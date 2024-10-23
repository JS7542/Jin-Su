class Solution {
    /*
     * 현재 행렬이 target과 같은지 확인한 뒤 시계 방향으로 90도 회전한다.
     * 최대 네 방향 중 하나라도 target과 같으면 true를 반환한다.
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int rotation = 0; rotation < 4; rotation++) {
            if (same(mat, target)) return true;
            mat = rotate(mat);
        }

        return false;
    }

    private boolean same(int[][] first, int[][] second) {
        for (int r = 0; r < first.length; r++) {
            for (int c = 0; c < first.length; c++) {
                if (first[r][c] != second[r][c]) return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) rotated[c][n - 1 - r] = matrix[r][c];
        }

        return rotated;
    }
}
