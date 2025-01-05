class Solution {
    /*
     * 양 끝에서 영문자가 아닌 문자를 건너뛴다.
     * 영문자끼리만 교환해 특수문자의 위치를 유지한다.
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }

        return new String(chars);
    }
}
