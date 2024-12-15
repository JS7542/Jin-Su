class Solution {
    /*
     * 현재 문자와 이전 문자가 같으면 연속 길이를 늘린다.
     * 문자가 바뀌면 길이를 1로 초기화하며 최대 길이를 갱신한다.
     */
    public int maxPower(String s) {
        int current = 1;
        int answer = 1;

        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i) == s.charAt(i - 1) ? current + 1 : 1;
            answer = Math.max(answer, current);
        }

        return answer;
    }
}
