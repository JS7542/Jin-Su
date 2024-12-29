class Solution {
    /*
     * n의 사용 비트 범위만 모두 1인 마스크를 만든다.
     * 마스크와 n을 XOR해 해당 범위의 비트를 반전한다.
     */
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 0;
        int value = n;

        while (value > 0) {
            mask = (mask << 1) | 1;
            value >>= 1;
        }

        return n ^ mask;
    }
}
