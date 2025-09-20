class Solution {
    /*
     * 각 인덱스를 홀수 회문의 중심과 짝수 회문의 중심으로 확장한다.
     * 가장 긴 회문의 시작 위치와 길이를 갱신해 부분문자열을 반환한다.
     */
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 1;

        for (int center = 0; center < s.length(); center++) {
            int odd = expand(s, center, center);
            int even = expand(s, center, center + 1);
            int length = Math.max(odd, even);

            if (length > maxLength) {
                maxLength = length;
                start = center - (length - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
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
