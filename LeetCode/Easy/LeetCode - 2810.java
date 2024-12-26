class Solution {
    /*
     * 일반 문자는 결과 뒤에 추가한다.
     * 문자 i를 만나면 현재까지 만든 문자열을 뒤집는다.
     */
    public String finalString(String s) {
        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == 'i') answer.reverse();
            else answer.append(ch);
        }

        return answer.toString();
    }
}
