class Solution {
    /*
     * 원소에 1,-1과 -1,1 두 펄스 패턴을 곱한 수열을 각각 만든 것으로 생각한다.
     * 두 패턴의 최대 연속 부분합을 카데인 알고리즘으로 동시에 계산한다.
     */
    public long solution(int[] sequence) {
        long currentFirst = 0;
        long currentSecond = 0;
        long answer = Long.MIN_VALUE;

        for (int index = 0; index < sequence.length; index++) {
            long firstValue = (index % 2 == 0 ? 1L : -1L) * sequence[index];
            long secondValue = -firstValue;

            currentFirst = Math.max(firstValue, currentFirst + firstValue);
            currentSecond = Math.max(secondValue, currentSecond + secondValue);

            answer = Math.max(answer, Math.max(currentFirst, currentSecond));
        }

        return answer;
    }
}
