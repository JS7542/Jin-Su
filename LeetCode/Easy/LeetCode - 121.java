class Solution {
    /*
     * 지금까지 본 최소 가격을 유지하며 오늘 팔았을 때의 이익을 계산한다.
     * 각 날의 이익 중 가장 큰 값을 정답으로 갱신한다.
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int answer = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            answer = Math.max(answer, price - minPrice);
        }

        return answer;
    }
}
