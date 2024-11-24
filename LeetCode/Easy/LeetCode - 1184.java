class Solution {
    /*
     * start에서 destination까지 시계 방향 거리와 전체 거리를 계산한다.
     * 시계 방향 거리와 반대 방향 거리 중 작은 값을 반환한다.
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int total = 0;
        int clockwise = 0;

        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= start && i < destination) clockwise += distance[i];
        }

        return Math.min(clockwise, total - clockwise);
    }
}
