import java.util.*;

class Solution {
    /*
     * 판매자별 추천인을 인덱스로 연결한다.
     * 판매 수익의 10%를 추천인에게 올리며 분배 금액이 0이 될 때까지 위로 전달한다.
     */
    public int[] solution(
            String[] enroll,
            String[] referral,
            String[] seller,
            int[] amount
    ) {
        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) index.put(enroll[i], i);

        int[] parent = new int[enroll.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < referral.length; i++) {
            if (!referral[i].equals("-")) parent[i] = index.get(referral[i]);
        }

        int[] profit = new int[enroll.length];

        for (int sale = 0; sale < seller.length; sale++) {
            int current = index.get(seller[sale]);
            int money = amount[sale] * 100;

            while (current != -1 && money > 0) {
                int commission = money / 10;
                profit[current] += money - commission;
                money = commission;
                current = parent[current];
            }
        }

        return profit;
    }
}
