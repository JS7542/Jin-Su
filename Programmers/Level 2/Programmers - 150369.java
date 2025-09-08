class Solution {
    /*
     * 가장 먼 집부터 미처리 배달·수거 상자 수를 누적한다.
     * 필요한 왕복 횟수만큼 용량을 차감해 남는 용량을 가까운 집 작업에 재사용한다.
     */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long pendingDelivery = 0;
        long pendingPickup = 0;

        for (int index = n - 1; index >= 0; index--) {
            pendingDelivery += deliveries[index];
            pendingPickup += pickups[index];

            long trips = Math.max(
                    (pendingDelivery + cap - 1) / cap,
                    (pendingPickup + cap - 1) / cap
            );

            if (trips > 0) {
                answer += trips * (index + 1) * 2L;
                pendingDelivery -= trips * cap;
                pendingPickup -= trips * cap;
            }
        }

        return answer;
    }
}
