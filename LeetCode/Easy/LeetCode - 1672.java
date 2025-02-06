class Solution {
    /*
     * 각 고객 행의 계좌 잔액을 모두 합산한다.
     * 고객별 합 중 가장 큰 값을 반환한다.
     */
    public int maximumWealth(int[][] accounts) {
        int answer = 0;

        for (int[] account : accounts) {
            int wealth = 0;
            for (int money : account) wealth += money;
            answer = Math.max(answer, wealth);
        }

        return answer;
    }
}
