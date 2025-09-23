class Solution {
    /*
     * 결과 문자열을 스택처럼 사용한다.
     * 현재 문자가 스택 마지막 문자와 같으면 제거하고 다르면 추가한다.
     */
    public int solution(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int size = stack.length();

            if (size > 0 && stack.charAt(size - 1) == ch) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.length() == 0 ? 1 : 0;
    }
}
