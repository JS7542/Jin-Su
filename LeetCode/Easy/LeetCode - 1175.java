class Solution {
    /*
     * 1부터 n까지의 소수 개수를 센다.
     * 소수 자리와 비소수 자리의 순열 수를 각각 팩토리얼로 계산해 곱한다.
     */
    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int value = 2; value <= n; value++) {
            if (isPrime(value)) primeCount++;
        }

        long mod = 1_000_000_007L;
        return (int) (factorial(primeCount, mod) * factorial(n - primeCount, mod) % mod);
    }

    private boolean isPrime(int n) {
        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) return false;
        }
        return n >= 2;
    }

    private long factorial(int n, long mod) {
        long result = 1;
        for (int value = 2; value <= n; value++) result = result * value % mod;
        return result;
    }
}
