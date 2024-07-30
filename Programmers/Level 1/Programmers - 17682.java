class Solution {
    /*
     * 숫자와 보너스를 읽어 각 기회의 점수를 계산한다.
     * 옵션 *과 #에 따라 현재 점수와 이전 점수를 조정한다.
     */
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int round = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if (Character.isDigit(ch)) {
                round++;
                if (ch == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    scores[round] = 10;
                    i++;
                } else {
                    scores[round] = ch - '0';
                }
            } else if (ch == 'D') {
                scores[round] *= scores[round];
            } else if (ch == 'T') {
                scores[round] = scores[round] * scores[round] * scores[round];
            } else if (ch == '*') {
                scores[round] *= 2;
                if (round > 0) scores[round - 1] *= 2;
            } else if (ch == '#') {
                scores[round] *= -1;
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}
