class Solution {
    /*
     * 괄호 깊이를 유지하며 가장 바깥쪽 괄호를 제외한 문자만 결과에 추가한다.
     * 여는 괄호는 증가 전, 닫는 괄호는 감소 후 깊이를 기준으로 판단한다.
     */
    public String removeOuterParentheses(String s) {
        StringBuilder answer = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) answer.append(ch);
                depth++;
            } else {
                depth--;
                if (depth > 0) answer.append(ch);
            }
        }

        return answer.toString();
    }
}
