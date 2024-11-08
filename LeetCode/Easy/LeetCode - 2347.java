class Solution {
    /*
     * 다섯 카드의 무늬가 모두 같으면 Flush다.
     * 숫자 빈도 최댓값에 따라 Three of a Kind, Pair, High Card를 결정한다.
     */
    public String bestHand(int[] ranks, char[] suits) {
        boolean flush = true;

        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) flush = false;
        }

        if (flush) return "Flush";

        int[] count = new int[14];
        int max = 0;

        for (int rank : ranks) max = Math.max(max, ++count[rank]);

        if (max >= 3) return "Three of a Kind";
        if (max == 2) return "Pair";
        return "High Card";
    }
}
