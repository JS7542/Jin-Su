class Solution {
    /*
     * 문자열이 비어 있으면 연산이 필요 없다.
     * 회문이면 한 번에 제거 가능하고, 아니면 a와 b를 각각 제거해 두 번이 필요하다.
     */
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return 2;
        }

        return 1;
    }
}
