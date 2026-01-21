import java.util.*;

class Solution {
    /*
     * 숫자와 연산자를 분리하고 세 연산자의 우선순위 순열을 모두 시도한다.
     * 각 우선순위마다 같은 연산자를 차례로 계산해 절댓값 최댓값을 구한다.
     */
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                current.append(ch);
            } else {
                numbers.add(Long.parseLong(current.toString()));
                current.setLength(0);
                operators.add(ch);
            }
        }

        numbers.add(Long.parseLong(current.toString()));

        char[][] orders = {
            {'+', '-', '*'}, {'+', '*', '-'},
            {'-', '+', '*'}, {'-', '*', '+'},
            {'*', '+', '-'}, {'*', '-', '+'}
        };

        long answer = 0;

        for (char[] order : orders) {
            List<Long> values = new ArrayList<>(numbers);
            List<Character> ops = new ArrayList<>(operators);

            for (char target : order) {
                for (int i = 0; i < ops.size();) {
                    if (ops.get(i) == target) {
                        long result = calculate(values.get(i), values.get(i + 1), target);
                        values.set(i, result);
                        values.remove(i + 1);
                        ops.remove(i);
                    } else {
                        i++;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(values.get(0)));
        }

        return answer;
    }

    private long calculate(long a, long b, char operator) {
        if (operator == '+') return a + b;
        if (operator == '-') return a - b;
        return a * b;
    }
}
