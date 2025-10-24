import java.util.*;

class Solution {
    /*
     * 문자열의 모든 회전 위치를 시작점으로 시도한다.
     * 스택으로 세 종류 괄호의 짝과 순서를 확인해 올바른 회전 수를 센다.
     */
    public int solution(String s) {
        int answer = 0;

        for (int shift = 0; shift < s.length(); shift++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (int offset = 0; offset < s.length(); offset++) {
                char ch = s.charAt((shift + offset) % s.length());

                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid && stack.isEmpty()) answer++;
        }

        return answer;
    }

    private boolean matches(char open, char close) {
        return open == '(' && close == ')'
                || open == '[' && close == ']'
                || open == '{' && close == '}';
    }
}
