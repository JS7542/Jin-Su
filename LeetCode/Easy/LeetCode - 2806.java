class Solution {
    /*
     * 구매 금액을 가장 가까운 10의 배수로 반올림한다.
     * 초기 잔액 100에서 반올림된 금액을 뺀다.
     */
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int rounded = ((purchaseAmount + 5) / 10) * 10;
        return 100 - rounded;
    }
}
