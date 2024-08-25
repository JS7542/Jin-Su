class Solution {
    /*
     * 인접한 두 문자의 코드 차이 절댓값을 계산한다.
     * 모든 인접 문자 쌍의 차이를 합산한다.
     */
    public int scoreOfString(String s) {
        int answer = 0;

        for (int i = 1; i < s.length(); i++) {
            answer += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return answer;
    }
}
