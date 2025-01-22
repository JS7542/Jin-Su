class Solution {
    /*
     * 각 정수의 가장 큰 자리수와 자리수 개수를 찾는다.
     * 모든 자리를 최댓값으로 채운 암호화 수를 합산한다.
     */
    public int sumOfEncryptedInt(int[] nums) {
        int answer = 0;

        for (int number : nums) {
            int value = number;
            int maxDigit = 0;
            int digits = 0;

            while (value > 0) {
                maxDigit = Math.max(maxDigit, value % 10);
                value /= 10;
                digits++;
            }

            int encrypted = 0;

            for (int i = 0; i < digits; i++) {
                encrypted = encrypted * 10 + maxDigit;
            }

            answer += encrypted;
        }

        return answer;
    }
}
