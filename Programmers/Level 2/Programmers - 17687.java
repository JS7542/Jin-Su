class Solution {
    /*
     * 0부터 숫자를 n진수 문자열로 이어 붙여 필요한 전체 길이를 만든다.
     * 튜브 차례에 해당하는 인덱스의 문자만 골라 결과를 구성한다.
     */
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        int number = 0;

        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(number++, n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();

        for (int turn = 0; turn < t; turn++) {
            answer.append(sequence.charAt(turn * m + p - 1));
        }

        return answer.toString();
    }
}
