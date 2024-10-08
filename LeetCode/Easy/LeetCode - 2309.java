class Solution {
    /*
     * 문자열에 등장한 대문자와 소문자를 각각 표시한다.
     * Z부터 A까지 두 형태가 모두 존재하는 가장 큰 문자를 찾는다.
     */
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) lower[ch - 'a'] = true;
            else upper[ch - 'A'] = true;
        }

        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) return String.valueOf((char) ('A' + i));
        }

        return "";
    }
}
