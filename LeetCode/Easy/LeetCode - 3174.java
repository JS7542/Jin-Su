class Solution {
    /*
     * 문자는 스택처럼 결과에 추가한다.
     * 숫자를 만나면 가장 최근에 추가한 문자를 제거한다.
     */
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) stack.deleteCharAt(stack.length() - 1);
            else stack.append(ch);
        }

        return stack.toString();
    }
}
