class Solution {
    /*
     * start와 goal에서 서로 다른 비트만 XOR 결과에서 1이 된다.
     * XOR 값의 1비트 개수를 최소 뒤집기 횟수로 반환한다.
     */
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
