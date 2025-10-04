class Solution {
    /*
     * 각 위치를 홀수 길이와 짝수 길이 팰린드롬의 중심으로 사용한다.
     * 양쪽 문자가 같은 동안 확장하며 발견한 팰린드롬 개수를 센다.
     */
    public int countSubstrings(String s) {
        int answer = 0;

        for (int center = 0; center < s.length(); center++) {
            answer += expand(s, center, center);
            answer += expand(s, center, center + 1);
        }

        return answer;
    }

    private int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
