class Solution {
    /*
     * k번째 사람보다 앞선 사람은 최대 tickets[k]장, 뒤 사람은 최대 tickets[k]-1장을 산다.
     * 각 사람이 실제로 구매하는 횟수를 합산해 전체 시간을 구한다.
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;

        for (int i = 0; i < tickets.length; i++) {
            int limit = i <= k ? tickets[k] : tickets[k] - 1;
            answer += Math.min(tickets[i], limit);
        }

        return answer;
    }
}
