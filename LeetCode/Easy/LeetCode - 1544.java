class Solution {
    /*
     * 결과 문자열의 마지막 문자와 현재 문자가 대소문자만 다른지 확인한다.
     * 해당하면 마지막 문자를 제거하고 아니면 현재 문자를 추가한다.
     */
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int length = stack.length();

            if (length > 0 && Math.abs(stack.charAt(length - 1) - ch) == 32) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}
