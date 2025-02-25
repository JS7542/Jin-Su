class Solution {
    /*
     * 배열의 마지막 자리부터 1을 더하고 올림을 처리한다.
     * 모든 자리가 9여서 올림이 남으면 길이가 하나 큰 배열을 만든다.
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }
}
