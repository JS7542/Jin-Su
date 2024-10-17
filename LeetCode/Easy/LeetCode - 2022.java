class Solution {
    /*
     * 전체 원소 수가 m*n과 다르면 빈 행렬을 반환한다.
     * 일차원 인덱스를 행 index/n과 열 index%n 위치로 변환한다.
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];

        int[][] answer = new int[m][n];

        for (int index = 0; index < original.length; index++) {
            answer[index / n][index % n] = original[index];
        }

        return answer;
    }
}
