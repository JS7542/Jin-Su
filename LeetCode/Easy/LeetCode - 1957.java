class Solution {
    /*
     * 결과 문자열의 마지막 두 문자가 현재 문자와 모두 같은지 확인한다.
     * 같은 문자가 세 번 연속되는 경우만 건너뛰고 나머지는 추가한다.
     */
    public String makeFancyString(String s) {
        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int length = answer.length();

            if (length >= 2
                    && answer.charAt(length - 1) == ch
                    && answer.charAt(length - 2) == ch) continue;

            answer.append(ch);
        }

        return answer.toString();
    }
}
