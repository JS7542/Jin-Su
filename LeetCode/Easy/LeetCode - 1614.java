class Solution {
    /*
     * 여는 괄호를 만나면 현재 깊이를 증가시키고 최댓값을 갱신한다.
     * 닫는 괄호를 만나면 현재 깊이를 감소시킨다.
     */
    public int maxDepth(String s) {
        int depth = 0;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') answer = Math.max(answer, ++depth);
            else if (ch == ')') depth--;
        }

        return answer;
    }
}
