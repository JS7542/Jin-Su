class Solution {
    /*
     * 뒤에 #이 있으면 앞의 두 숫자를 10부터 26까지의 값으로 해석한다.
     * 그 외에는 한 자리 숫자를 1부터 9까지의 알파벳으로 변환한다.
     */
    public String freqAlphabets(String s) {
        StringBuilder answer = new StringBuilder();

        for (int i = s.length() - 1; i >= 0;) {
            int value;

            if (s.charAt(i) == '#') {
                value = Integer.parseInt(s.substring(i - 2, i));
                i -= 3;
            } else {
                value = s.charAt(i) - '0';
                i--;
            }

            answer.append((char) ('a' + value - 1));
        }

        return answer.reverse().toString();
    }
}
