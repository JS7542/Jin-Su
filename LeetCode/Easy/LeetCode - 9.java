class Solution {
    /*
     * 음수와 끝자리가 0인 양수는 회문이 될 수 없으므로 먼저 제외한다.
     * 숫자의 뒤 절반만 뒤집어 앞 절반과 같은지 비교한다.
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}
