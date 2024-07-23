class Solution {
    /*
     * 숫자 문자열의 각 문자를 한 자리 정수로 변환한다.
     * 모든 자리수의 합을 누적해 반환한다.
     */
    public int solution(String num_str) {
        int answer = 0;
        for (char ch : num_str.toCharArray()) answer += ch - '0';
        return answer;
    }
}
