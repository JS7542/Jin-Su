import java.util.*;

class Solution {
    /*
     * 여는 괄호와 닫는 괄호 사용 개수를 추적하며 백트래킹한다.
     * 닫는 괄호는 사용한 여는 괄호보다 적을 때만 추가할 수 있다.
     */
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(
            int n,
            int open,
            int close,
            StringBuilder current,
            List<String> answer
    ) {
        if (current.length() == n * 2) {
            answer.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            build(n, open + 1, close, current, answer);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            build(n, open, close + 1, current, answer);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
