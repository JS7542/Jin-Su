class Solution {
    /*
     * 숫자를 문자열로 바꾸어 왼쪽 자리부터 순회한다.
     * 짝수 인덱스 자리수는 더하고 홀수 인덱스 자리수는 뺀다.
     */
    public int alternateDigitSum(int n) {
        String text = String.valueOf(n);
        int answer = 0;

        for (int i = 0; i < text.length(); i++) {
            int digit = text.charAt(i) - '0';
            answer += i % 2 == 0 ? digit : -digit;
        }

        return answer;
    }
}
