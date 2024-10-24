class Solution {
    /*
     * 양 끝 문자가 다르면 더 작은 문자를 양쪽에 배치한다.
     * 모든 쌍을 처리해 사전순으로 가장 작은 회문을 만든다.
     */
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char smaller = (char) Math.min(chars[left], chars[right]);
            chars[left++] = smaller;
            chars[right--] = smaller;
        }

        return new String(chars);
    }
}
