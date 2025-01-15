class Solution {
    /*
     * 숫자가 아닌 문자를 제거한 뒤 앞에서부터 세 자리씩 묶는다.
     * 마지막 네 자리는 두 자리씩 나누고 나머지는 한 그룹으로 처리한다.
     */
    public String reformatNumber(String number) {
        String digits = number.replaceAll("[^0-9]", "");
        StringBuilder answer = new StringBuilder();
        int index = 0;

        while (digits.length() - index > 4) {
            if (answer.length() > 0) answer.append('-');
            answer.append(digits, index, index + 3);
            index += 3;
        }

        int remaining = digits.length() - index;
        if (answer.length() > 0) answer.append('-');

        if (remaining == 4) {
            answer.append(digits, index, index + 2)
                  .append('-')
                  .append(digits, index + 2, index + 4);
        } else {
            answer.append(digits.substring(index));
        }

        return answer.toString();
    }
}
