class Solution {
    /*
     * 양 끝 포인터를 사용해 영문자와 숫자가 아닌 문자를 건너뛴다.
     * 남은 문자를 소문자로 비교하며 가운데까지 모두 같으면 회문이다.
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }

        return true;
    }
}
