class Solution {
    /*
     * 각 가격 오른쪽에서 처음으로 현재 가격 이하인 값을 찾는다.
     * 찾은 값을 할인액으로 빼고 없으면 원래 가격을 유지한다.
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}
