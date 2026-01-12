class Solution {
    /*
     * 전체 가스가 전체 비용보다 적으면 완주할 수 없다.
     * 누적 연료가 음수가 되는 지점 다음을 새로운 시작점으로 잡는다.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int difference = gas[i] - cost[i];
            total += difference;
            tank += difference;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}
