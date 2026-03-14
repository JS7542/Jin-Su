class Solution {
    /*
     * 각 날짜에 주식을 보유한 상태, 방금 판매한 상태, 쉬는 상태의 최대 이익을 관리한다.
     * 판매 다음 날에는 바로 구매할 수 없도록 이전 쉬는 상태에서만 구매한다.
     */
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int day = 1; day < prices.length; day++) {
            int previousHold = hold;
            int previousSold = sold;
            int previousRest = rest;

            hold = Math.max(previousHold, previousRest - prices[day]);
            sold = previousHold + prices[day];
            rest = Math.max(previousRest, previousSold);
        }

        return Math.max(sold, rest);
    }
}
