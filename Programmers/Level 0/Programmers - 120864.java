class Solution {
    /*
     * 문자열을 순회하며 연속된 숫자 문자를 하나의 정수로 조립한다.
     * 문자를 만나거나 문자열이 끝날 때 완성된 정수를 합에 더한다.
     */
    public int solution(String my_string) {
        int answer = 0;
        int number = 0;

        for (int i = 0; i <= my_string.length(); i++) {
            if (i < my_string.length() && Character.isDigit(my_string.charAt(i))) {
                number = number * 10 + my_string.charAt(i) - '0';
            } else {
                answer += number;
                number = 0;
            }
        }

        return answer;
    }
}
