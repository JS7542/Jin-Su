class Solution {
    /*
     * 문자 1을 만나면 mode를 0과 1 사이에서 전환한다.
     * 현재 mode와 인덱스 홀짝이 같은 일반 문자만 결과에 추가한다.
     */
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);

            if (ch == '1') mode = 1 - mode;
            else if (i % 2 == mode) answer.append(ch);
        }

        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}
