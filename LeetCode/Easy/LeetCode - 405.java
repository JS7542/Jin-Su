class Solution {
    /*
     * 정수를 unsigned 방식으로 오른쪽 이동하며 4비트씩 처리한다.
     * 각 4비트 값을 16진수 문자로 바꾼 뒤 결과를 뒤집는다.
     */
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] digits = "0123456789abcdef".toCharArray();
        StringBuilder answer = new StringBuilder();

        while (num != 0) {
            answer.append(digits[num & 15]);
            num >>>= 4;
        }

        return answer.reverse().toString();
    }
}
