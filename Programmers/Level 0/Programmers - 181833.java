class Solution {
    /*
     * n×n 정사각 행렬을 생성한다.
     * 행과 열 인덱스가 같은 주대각선 위치만 1로 설정한다.
     */
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) answer[i][i] = 1;
        return answer;
    }
}
