class Solution {
    /*
     * 나이의 각 숫자 0부터 9를 알파벳 a부터 j로 변환한다.
     * 숫자 문자열을 순회하며 대응하는 문자를 이어 붙인다.
     */
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        for (char ch : String.valueOf(age).toCharArray()) {
            sb.append((char) ('a' + ch - '0'));
        }
        return sb.toString();
    }
}
