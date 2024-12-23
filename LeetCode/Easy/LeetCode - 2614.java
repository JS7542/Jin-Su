class Solution {
    /*
     * 주대각선과 부대각선의 값을 확인한다.
     * 소수인 대각선 값 중 가장 큰 값을 반환한다.
     */
    public int diagonalPrime(int[][] nums) {
        int answer = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) answer = Math.max(answer, nums[i][i]);
            if (isPrime(nums[i][n - 1 - i])) answer = Math.max(answer, nums[i][n - 1 - i]);
        }

        return answer;
    }

    private boolean isPrime(int value) {
        if (value < 2) return false;

        for (int divisor = 2; divisor * divisor <= value; divisor++) {
            if (value % divisor == 0) return false;
        }

        return true;
    }
}
