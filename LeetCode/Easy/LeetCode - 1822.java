class Solution {
    /*
     * 0이 존재하면 곱의 부호는 0이다.
     * 음수의 개수를 세어 홀수이면 -1, 짝수이면 1을 반환한다.
     */
    public int arraySign(int[] nums) {
        int negative = 0;

        for (int number : nums) {
            if (number == 0) return 0;
            if (number < 0) negative++;
        }

        return negative % 2 == 0 ? 1 : -1;
    }
}
