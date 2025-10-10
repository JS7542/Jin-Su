class Solution {
    /*
     * 결과 행렬의 각 칸은 첫 행렬의 행과 두 번째 행렬의 열의 내적이다.
     * 세 중첩 반복으로 모든 내적 값을 계산한다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr2[0].length;
        int common = arr2.length;

        int[][] answer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int index = 0; index < common; index++) {
                    answer[row][col] += arr1[row][index] * arr2[index][col];
                }
            }
        }

        return answer;
    }
}
