class Solution {
    /*
     * 문자열 배열을 앞에서부터 확인하며 회문인지 검사한다.
     * 처음 발견한 회문 문자열을 반환하고 없으면 빈 문자열을 반환한다.
     */
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (palindrome(word)) return word;
        }
        return "";
    }

    private boolean palindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }

        return true;
    }
}
