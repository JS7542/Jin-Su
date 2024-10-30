class Solution {
    /*
     * 값이 1인 항목을 먼저, 그다음 0, 마지막으로 -1 항목을 선택한다.
     * 선택한 1의 개수에서 선택한 -1의 개수를 빼 결과를 계산한다.
     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ones = Math.min(k, numOnes);
        k -= ones;

        int zeros = Math.min(k, numZeros);
        k -= zeros;

        return ones - k;
    }
}
