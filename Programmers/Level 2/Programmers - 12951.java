class Solution {
    /*
     * 단어의 첫 문자는 대문자, 나머지 문자는 소문자로 변환한다.
     * 공백이 연속될 수 있으므로 이전 문자가 공백인지 직접 추적한다.
     */
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean wordStart = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(ch);
                wordStart = true;
            } else {
                answer.append(wordStart
                        ? Character.toUpperCase(ch)
                        : Character.toLowerCase(ch));
                wordStart = false;
            }
        }

        return answer.toString();
    }
}
