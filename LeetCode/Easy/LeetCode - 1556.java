class Solution {
    /*
     * 숫자 문자열의 뒤에서부터 세 자리마다 점을 추가한다.
     * 역순으로 만든 결과를 다시 뒤집어 천 단위 구분 형식을 완성한다.
     */
    public String thousandSeparator(int n) {
        String text = String.valueOf(n);
        StringBuilder answer = new StringBuilder();

        for (int i = text.length() - 1, count = 0; i >= 0; i--, count++) {
            if (count > 0 && count % 3 == 0) answer.append('.');
            answer.append(text.charAt(i));
        }

        return answer.reverse().toString();
    }
}
