class Solution {
    /*
     * 가장 저렴한 초콜릿 두 개의 가격을 찾는다.
     * 두 가격 합이 가진 돈 이하이면 남은 돈을, 아니면 원래 돈을 반환한다.
     */
    public int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < first) {
                second = first;
                first = price;
            } else if (price < second) {
                second = price;
            }
        }

        int cost = first + second;
        return cost <= money ? money - cost : money;
    }
}
