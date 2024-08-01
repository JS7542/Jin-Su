class Solution {
    /*
     * 문자 배열의 양 끝에서 시작해 서로의 값을 교환한다.
     * 두 포인터가 만날 때까지 안쪽으로 이동하며 배열을 뒤집는다.
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
