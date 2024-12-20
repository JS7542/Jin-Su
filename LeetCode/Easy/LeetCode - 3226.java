class Solution {
    /*
     * k에 1인 비트가 n에는 0이면 1을 새로 만들 수 없어 불가능하다.
     * 가능하면 n과 k가 다른 비트 중 n의 1을 0으로 바꾸는 개수를 센다.
     */
    public int minChanges(int n, int k) {
        if ((n & k) != k) return -1;
        return Integer.bitCount(n ^ k);
    }
}
