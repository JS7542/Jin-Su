class Solution {
    /*
     * 각 열의 모든 값을 문자열로 바꾸어 길이를 확인한다.
     * 열마다 가장 긴 문자열 길이를 결과 배열에 저장한다.
     */
    public int[] findColumnWidth(int[][] grid) {
        int[] answer = new int[grid[0].length];

        for (int column = 0; column < grid[0].length; column++) {
            for (int[] row : grid) {
                answer[column] = Math.max(answer[column], String.valueOf(row[column]).length());
            }
        }

        return answer;
    }
}
