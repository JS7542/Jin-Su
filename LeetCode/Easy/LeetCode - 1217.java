class Solution {
    /*
     * 같은 홀짝 위치 사이의 이동 비용은 0이므로 칩을 홀수와 짝수 위치로 나눈다.
     * 더 적은 그룹만 비용 1로 이동시키면 최소 비용이 된다.
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for (int value : position) {
            if (value % 2 == 0) even++;
            else odd++;
        }

        return Math.min(odd, even);
    }
}
