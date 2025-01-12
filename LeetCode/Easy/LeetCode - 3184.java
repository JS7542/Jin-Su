class Solution {
    /*
     * 모든 i<j 시간 쌍을 확인한다.
     * 두 시간의 합이 24의 배수인 쌍의 개수를 센다.
     */
    public int countCompleteDayPairs(int[] hours) {
        int answer = 0;

        for (int i = 0; i < hours.length - 1; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) answer++;
            }
        }

        return answer;
    }
}
