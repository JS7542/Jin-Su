class Solution {
    /*
     * 두 짝수를 OR하면 최하위 비트가 0으로 남는다.
     * 배열에 짝수가 두 개 이상 있는지 확인한다.
     */
    public boolean hasTrailingZeros(int[] nums) {
        int even = 0;

        for (int number : nums) {
            if (number % 2 == 0 && ++even >= 2) return true;
        }

        return false;
    }
}
