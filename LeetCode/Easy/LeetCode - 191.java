class Solution {
    /*
     * n과 n-1을 AND하면 가장 낮은 1비트가 하나 제거된다.
     * n이 0이 될 때까지 반복한 횟수가 1비트 개수다.
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }
}
