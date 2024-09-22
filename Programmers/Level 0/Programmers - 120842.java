class Solution {
    /*
     * 일차원 배열을 n개씩 묶을 수 있도록 행 개수를 계산한다.
     * 원본 인덱스 i를 행 i/n, 열 i%n 위치에 저장한다.
     */
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }

        return answer;
    }
}
