import java.util.*;

class Solution {
    /*
     * 여는 괄호는 스택에 저장하고 닫는 괄호는 가장 최근 여는 괄호와 짝을 확인한다.
     * 중간에 짝이 맞지 않거나 마지막에 스택이 남으면 유효하지 않다.
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (ch == ')' && open != '(') return false;
                if (ch == ']' && open != '[') return false;
                if (ch == '}' && open != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
