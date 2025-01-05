class Solution {
    /*
     * 각 작업 시간은 현재 종료 시간에서 이전 종료 시간을 뺀 값이다.
     * 더 긴 작업 또는 같은 시간의 더 작은 직원 ID를 선택한다.
     */
    public int hardestWorker(int n, int[][] logs) {
        int answer = logs[0][0];
        int longest = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            int duration = logs[i][1] - logs[i - 1][1];
            int employee = logs[i][0];

            if (duration > longest || (duration == longest && employee < answer)) {
                longest = duration;
                answer = employee;
            }
        }

        return answer;
    }
}
