class Solution {
    /*
     * 선수별로 각 색 공을 집은 횟수를 센다.
     * 어떤 색이라도 선수 번호보다 많이 집었다면 승리한 선수로 센다.
     */
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] count = new int[n][11];

        for (int[] event : pick) count[event[0]][event[1]]++;

        int answer = 0;

        for (int player = 0; player < n; player++) {
            for (int color = 0; color <= 10; color++) {
                if (count[player][color] > player) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
