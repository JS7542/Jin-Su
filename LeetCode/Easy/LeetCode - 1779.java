class Solution {
    /*
     * x좌표 또는 y좌표가 같은 유효한 점만 확인한다.
     * 맨해튼 거리가 가장 짧은 첫 점의 인덱스를 반환한다.
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int answer = -1;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] != x && points[i][1] != y) continue;

            int distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
            if (distance < best) {
                best = distance;
                answer = i;
            }
        }

        return answer;
    }
}
