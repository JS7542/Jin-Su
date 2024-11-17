class Solution {
    /*
     * 세 문자열의 공통 접두사 길이를 계산한다.
     * 공통 문자가 없으면 -1, 있으면 전체 길이에서 세 접두사 길이를 뺀다.
     */
    public int findMinimumOperations(String s1, String s2, String s3) {
        int common = 0;
        int limit = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        while (common < limit
                && s1.charAt(common) == s2.charAt(common)
                && s2.charAt(common) == s3.charAt(common)) {
            common++;
        }

        if (common == 0) return -1;
        return s1.length() + s2.length() + s3.length() - common * 3;
    }
}
