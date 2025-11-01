class Solution {
    /*
     * 현재 숫자와 직전 연산자를 유지하며 문자열을 한 번 순회한다.
     * 곱셈·나눗셈은 현재 항에 즉시 적용하고 덧셈·뺄셈에서 완성된 항을 합에 반영한다.
     */
    public int calculate(String s) {
        long result = 0;
        long term = 0;
        long number = 0;
        char operator = '+';

        for (int index = 0; index <= s.length(); index++) {
            char current = index < s.length() ? s.charAt(index) : '+';

            if (Character.isDigit(current)) {
                number = number * 10 + current - '0';
                continue;
            }

            if (current == ' ') continue;

            if (operator == '+') {
                result += term;
                term = number;
            } else if (operator == '-') {
                result += term;
                term = -number;
            } else if (operator == '*') {
                term *= number;
            } else {
                term /= number;
            }

            operator = current;
            number = 0;
        }

        return (int) (result + term);
    }
}
