class Solution {
    /*
     * 각 위치를 홀수 길이와 짝수 길이 팰린드롬의 중심으로 확장한다.
     * 양쪽 문자가 같은 동안 확장해 가장 긴 길이를 구한다.
     */
    public int solution(String s) {
        int answer = 1;

        for (int center = 0; center < s.length(); center++) {
            answer = Math.max(answer, expand(s, center, center));
            answer = Math.max(answer, expand(s, center, center + 1));
        }

        return answer;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
