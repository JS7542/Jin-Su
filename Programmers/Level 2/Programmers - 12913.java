class Solution {
    /*
     * 현재 행의 각 열에는 이전 행의 다른 세 열 중 최댓값을 더한다.
     * 마지막 행의 네 값 중 최댓값을 반환한다.
     */
    int solution(int[][] land) {
        for (int row = 1; row < land.length; row++) {
            for (int col = 0; col < 4; col++) {
                int best = 0;

                for (int previous = 0; previous < 4; previous++) {
                    if (previous != col) best = Math.max(best, land[row - 1][previous]);
                }

                land[row][col] += best;
            }
        }

        int answer = 0;
        for (int value : land[land.length - 1]) answer = Math.max(answer, value);

        return answer;
    }
}
