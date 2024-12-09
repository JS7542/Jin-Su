class Solution {
    /*
     * 각 계단에 도달하는 최소 비용은 이전 두 위치 중 작은 비용에 현재 비용을 더한 값이다.
     * 마지막에는 끝으로 이동 가능한 두 위치의 최소 비용을 반환한다.
     */
    public int minCostClimbingStairs(int[] cost) {
        int first = 0;
        int second = 0;

        for (int value : cost) {
            int next = Math.min(first, second) + value;
            first = second;
            second = next;
        }

        return Math.min(first, second);
    }
}
