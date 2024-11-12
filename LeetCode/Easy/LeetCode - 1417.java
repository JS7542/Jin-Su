class Solution {
    /*
     * 숫자와 영문자를 각각 별도 문자열에 모은다.
     * 두 개수 차이가 1 이하일 때 많은 종류부터 번갈아 배치한다.
     */
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) digits.append(ch);
            else letters.append(ch);
        }

        if (Math.abs(letters.length() - digits.length()) > 1) return "";

        StringBuilder first = letters.length() >= digits.length() ? letters : digits;
        StringBuilder second = letters.length() >= digits.length() ? digits : letters;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            answer.append(first.charAt(i));
            if (i < second.length()) answer.append(second.charAt(i));
        }

        return answer.toString();
    }
}
