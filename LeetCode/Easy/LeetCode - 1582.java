class Solution {
    /*
     * 각 행과 열에 존재하는 1의 개수를 미리 센다.
     * 값이 1이면서 해당 행과 열의 1 개수가 모두 하나인 위치를 센다.
     */
    public int numSpecial(int[][] mat) {
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1 && rowCount[r] == 1 && colCount[c] == 1) answer++;
            }
        }

        return answer;
    }
}
