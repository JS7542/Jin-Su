import java.util.*;

class Solution {
    /*
     * 반복 횟수와 이전 문자열을 각각 스택에 저장한다.
     * 닫는 괄호를 만나면 현재 문자열을 반복해 이전 문자열 뒤에 이어 붙인다.
     */
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> strings = new ArrayDeque<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            } else if (ch == '[') {
                counts.push(number);
                strings.push(current);
                number = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                int repeat = counts.pop();
                StringBuilder previous = strings.pop();

                previous.append(current.toString().repeat(repeat));
                current = previous;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
