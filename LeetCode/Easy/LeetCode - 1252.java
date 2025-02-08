class Solution {
    /*
     * 각 연산에서 증가한 행과 열의 횟수 홀짝만 기록한다.
     * 행과 열의 홀짝 합이 홀수인 칸의 개수를 센다.
     */
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int[] index : indices) {
            rows[index[0]] = !rows[index[0]];
            cols[index[1]] = !cols[index[1]];
        }

        int answer = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rows[r] ^ cols[c]) answer++;
            }
        }

        return answer;
    }
}
