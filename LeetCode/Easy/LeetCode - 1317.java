class Solution {
    /*
     * 1부터 n-1까지 첫 번째 수를 증가시키며 두 수 모두 0을 포함하지 않는지 확인한다.
     * 조건을 처음 만족한 두 수를 반환한다.
     */
    public int[] getNoZeroIntegers(int n) {
        for (int first = 1; first < n; first++) {
            int second = n - first;
            if (noZero(first) && noZero(second)) return new int[]{first, second};
        }

        return new int[0];
    }

    private boolean noZero(int value) {
        while (value > 0) {
            if (value % 10 == 0) return false;
            value /= 10;
        }
        return true;
    }
}
