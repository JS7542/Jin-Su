class Solution {
    /*
     * 주대각선을 기준으로 대칭인 위치 arr[i][j]와 arr[j][i]를 비교한다.
     * 하나라도 다르면 0, 모든 위치가 같으면 1을 반환한다.
     */
    public int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return 1;
    }
}
