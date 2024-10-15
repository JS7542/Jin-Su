class Solution {
    /*
     * 각 학생의 시작 시간과 종료 시간 사이에 queryTime이 포함되는지 확인한다.
     * 조건을 만족하는 학생 수를 센다.
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) answer++;
        }

        return answer;
    }
}
