class Solution {
    /*
     * 도착 시간과 지연 시간을 더한다.
     * 24시간을 넘으면 24로 나눈 나머지를 반환한다.
     */
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
