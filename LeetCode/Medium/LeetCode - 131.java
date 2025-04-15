import java.util.*;

class Solution {
    /*
     * 현재 위치부터 가능한 모든 회문 부분문자열을 선택한다.
     * 문자열 끝까지 도달하면 현재 분할 목록을 결과에 복사한다.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        build(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            String s,
            int start,
            List<String> current,
            List<List<String>> answer
    ) {
        if (start == s.length()) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!palindrome(s, start, end)) continue;

            current.add(s.substring(start, end + 1));
            build(s, end + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }

    private boolean palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
