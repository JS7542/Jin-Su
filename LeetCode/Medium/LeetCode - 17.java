import java.util.*;

class Solution {
    /*
     * 각 숫자에 대응하는 문자 집합을 미리 정의한다.
     * 현재 숫자의 가능한 문자를 하나씩 선택하며 백트래킹한다.
     */
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;

        build(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(
            String digits,
            int index,
            StringBuilder current,
            List<String> answer
    ) {
        if (index == digits.length()) {
            answer.add(current.toString());
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            build(digits, index + 1, current, answer);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
