class Solution {
    /*
     * 문자열을 왼쪽부터 보며 등장한 문자를 boolean 배열에 표시한다.
     * 이미 표시된 문자를 처음 만나면 해당 문자를 반환한다.
     */
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (seen[ch - 'a']) return ch;
            seen[ch - 'a'] = true;
        }

        return 0;
    }
}
