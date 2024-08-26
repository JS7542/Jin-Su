class Solution {
    /*
     * 소문자와 대문자의 등장 여부를 각각 기록한다.
     * 두 형태가 모두 등장한 알파벳의 개수를 센다.
     */
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) lower[ch - 'a'] = true;
            else upper[ch - 'A'] = true;
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) answer++;
        }

        return answer;
    }
}
