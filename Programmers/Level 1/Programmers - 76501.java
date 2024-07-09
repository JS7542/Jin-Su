class Solution {
    /*
     * signs가 true이면 절댓값을 더하고 false이면 뺀다.
     * 모든 정수의 실제 부호를 적용한 합을 반환한다.
     */
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
