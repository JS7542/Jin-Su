class Solution {
    /*
     * 각 직원의 근무 시간이 target 이상인지 확인한다.
     * 조건을 만족하는 직원의 수를 센다.
     */
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int answer = 0;
        for (int hour : hours) if (hour >= target) answer++;
        return answer;
    }
}
