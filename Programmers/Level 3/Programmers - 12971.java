class Solution {
    /*
     * 원형 배열에서는 첫 스티커와 마지막 스티커를 동시에 고를 수 없다.
     * 첫 스티커를 포함하는 경우와 제외하는 경우를 선형 DP로 나누어 최댓값을 구한다.
     */
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];

        return Math.max(
                collect(sticker, 0, sticker.length - 2),
                collect(sticker, 1, sticker.length - 1)
        );
    }

    private int collect(int[] sticker, int start, int end) {
        int twoBack = 0;
        int oneBack = 0;

        for (int index = start; index <= end; index++) {
            int current = Math.max(oneBack, twoBack + sticker[index]);
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
