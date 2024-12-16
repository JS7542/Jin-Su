class Solution {
    /*
     * 결과 문자열을 스택처럼 사용한다.
     * 마지막 문자와 현재 문자가 AB 또는 CD를 만들면 제거하고 아니면 추가한다.
     */
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int length = stack.length();

            if (length > 0
                    && ((stack.charAt(length - 1) == 'A' && ch == 'B')
                    || (stack.charAt(length - 1) == 'C' && ch == 'D'))) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.length();
    }
}
