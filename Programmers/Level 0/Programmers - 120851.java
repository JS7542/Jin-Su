class Solution {
    /*
     * 문자열을 순회하며 숫자인 문자만 골라낸다.
     * 각 숫자 문자를 정수로 변환해 합을 누적한다.
     */
    public int solution(String my_string) {
        int answer = 0;
        for (char ch : my_string.toCharArray()) {
            if (Character.isDigit(ch)) answer += ch - '0';
        }
        return answer;
    }
}
