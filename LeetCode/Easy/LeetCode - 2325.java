class Solution {
    /*
     * key에서 처음 등장하는 소문자를 a부터 차례대로 매핑한다.
     * message의 공백은 유지하고 문자는 매핑된 문자로 변환한다.
     */
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char next = 'a';

        for (char ch : key.toCharArray()) {
            if (ch != ' ' && map[ch - 'a'] == 0) map[ch - 'a'] = next++;
        }

        StringBuilder answer = new StringBuilder();

        for (char ch : message.toCharArray()) {
            answer.append(ch == ' ' ? ' ' : map[ch - 'a']);
        }

        return answer.toString();
    }
}
