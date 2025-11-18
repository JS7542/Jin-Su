class Solution {
    /*
     * 원형 마을에서는 첫 집과 마지막 집을 동시에 털 수 없다.
     * 첫 집을 포함하는 경우와 제외하는 경우의 선형 DP 최댓값을 비교한다.
     */
    public int solution(int[] money) {
        if (money.length == 1) return money[0];

        return Math.max(
                rob(money, 0, money.length - 2),
                rob(money, 1, money.length - 1)
        );
    }

    private int rob(int[] money, int start, int end) {
        int twoBack = 0;
        int oneBack = 0;

        for (int index = start; index <= end; index++) {
            int current = Math.max(oneBack, twoBack + money[index]);
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
