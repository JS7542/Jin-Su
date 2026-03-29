import java.util.*;

class Solution {
    /*
     * 정수 부분을 계산한 뒤 나머지별 소수 문자열 위치를 해시맵에 저장한다.
     * 같은 나머지가 다시 나오면 해당 위치부터 반복되므로 괄호를 삽입한다.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder answer = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) answer.append('-');

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        answer.append(dividend / divisor);
        long remainder = dividend % divisor;

        if (remainder == 0) return answer.toString();

        answer.append('.');
        Map<Long, Integer> position = new HashMap<>();

        while (remainder != 0) {
            if (position.containsKey(remainder)) {
                int repeatStart = position.get(remainder);
                answer.insert(repeatStart, '(');
                answer.append(')');
                break;
            }

            position.put(remainder, answer.length());
            remainder *= 10;
            answer.append(remainder / divisor);
            remainder %= divisor;
        }

        return answer.toString();
    }
}
