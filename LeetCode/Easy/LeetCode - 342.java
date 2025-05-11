class Solution {
    /*
     * 4의 거듭제곱은 양수이며 1비트만 켜져 있어야 한다.
     * 해당 비트가 짝수 위치에 있는지 전용 비트 마스크로 확인한다.
     */
    public boolean isPowerOfFour(int n) {
        return n > 0
                && (n & (n - 1)) == 0
                && (n & 0x55555555) != 0;
    }
}
