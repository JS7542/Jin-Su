class Solution {
    /*
     * 고도 변화량을 순서대로 누적해 현재 고도를 계산한다.
     * 출발 고도 0을 포함한 전체 고도 중 최댓값을 반환한다.
     */
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int answer = 0;

        for (int change : gain) {
            altitude += change;
            answer = Math.max(answer, altitude);
        }

        return answer;
    }
}
