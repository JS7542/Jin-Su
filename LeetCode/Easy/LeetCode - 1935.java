class Solution {
    /*
     * 고장 난 문자를 boolean 배열에 표시한다.
     * 문장의 각 단어에 고장 난 문자가 하나도 없으면 입력 가능한 단어로 센다.
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) broken[ch - 'a'] = true;

        int answer = 0;

        for (String word : text.split(" ")) {
            boolean possible = true;

            for (char ch : word.toCharArray()) {
                if (broken[ch - 'a']) {
                    possible = false;
                    break;
                }
            }

            if (possible) answer++;
        }

        return answer;
    }
}
