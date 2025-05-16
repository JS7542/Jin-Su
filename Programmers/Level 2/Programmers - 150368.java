class Solution {
    /*
     * 각 이모티콘에 10·20·30·40% 할인율을 적용하는 모든 조합을 탐색한다.
     * 사용자별 구매액과 가입 여부를 계산해 가입자 수, 매출 순으로 최적 결과를 갱신한다.
     */
    private int[][] users;
    private int[] emoticons;
    private int[] discounts;
    private int bestSubscribers;
    private int bestRevenue;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.discounts = new int[emoticons.length];

        search(0);

        return new int[]{bestSubscribers, bestRevenue};
    }

    private void search(int index) {
        if (index == emoticons.length) {
            evaluate();
            return;
        }

        for (int discount : new int[]{10, 20, 30, 40}) {
            discounts[index] = discount;
            search(index + 1);
        }
    }

    private void evaluate() {
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int purchase = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= user[0]) {
                    purchase += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (purchase >= user[1]) subscribers++;
            else revenue += purchase;
        }

        if (subscribers > bestSubscribers
                || (subscribers == bestSubscribers && revenue > bestRevenue)) {
            bestSubscribers = subscribers;
            bestRevenue = revenue;
        }
    }
}
