class Solution {
    /*
     * 두 행렬의 같은 위치 원소를 더한다.
     * 합을 첫 번째 행렬에 저장해 결과 행렬로 반환한다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for (int r = 0; r < arr1.length; r++) {
            for (int c = 0; c < arr1[0].length; c++) {
                arr1[r][c] += arr2[r][c];
            }
        }
        return arr1;
    }
}
