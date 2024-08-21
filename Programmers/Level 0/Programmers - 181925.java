class Solution {
    /*
     * 연속한 두 로그 값의 차이를 확인한다.
     * 1, -1, 10, -10을 각각 w, s, d, a 문자로 변환한다.
     */
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < numLog.length; i++) {
            int difference = numLog[i] - numLog[i - 1];

            if (difference == 1) answer.append('w');
            else if (difference == -1) answer.append('s');
            else if (difference == 10) answer.append('d');
            else answer.append('a');
        }

        return answer.toString();
    }
}
