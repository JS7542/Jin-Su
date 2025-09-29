class Solution {
    /*
     * 문자열을 가장 짧은 균형 문자열 u와 나머지 v로 분리한다.
     * u가 올바르면 v를 재귀 변환해 붙이고, 아니면 규칙에 따라 뒤집어 조합한다.
     */
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int balance = 0;
        int split = 0;

        do {
            balance += p.charAt(split++) == '(' ? 1 : -1;
        } while (balance != 0);

        String u = p.substring(0, split);
        String v = p.substring(split);

        if (valid(u)) return u + solution(v);

        StringBuilder answer = new StringBuilder("(");
        answer.append(solution(v)).append(')');

        for (int i = 1; i < u.length() - 1; i++) {
            answer.append(u.charAt(i) == '(' ? ')' : '(');
        }

        return answer.toString();
    }

    private boolean valid(String text) {
        int balance = 0;

        for (char ch : text.toCharArray()) {
            balance += ch == '(' ? 1 : -1;
            if (balance < 0) return false;
        }

        return true;
    }
}
