class Solution {
    /*
     * 서로 다른 세 숫자를 고르는 모든 조합을 확인한다.
     * 세 수의 합이 소수인 조합의 개수를 센다.
     */
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) return false;
        }
        return n >= 2;
    }
}
