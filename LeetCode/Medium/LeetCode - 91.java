class Solution {
    /*
     * 한 자리 해석과 유효한 두 자리 해석의 경우의 수를 더한다.
     * 최근 두 DP 값만 유지해 문자열 끝까지 계산한다.
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int twoBack = 1;
        int oneBack = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            if (s.charAt(i) != '0') current += oneBack;

            int pair = Integer.parseInt(s.substring(i - 1, i + 1));
            if (pair >= 10 && pair <= 26) current += twoBack;

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
