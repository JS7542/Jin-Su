class Solution {
    /*
     * 각 소수가 가리키는 ugly 수 인덱스를 유지한다.
     * 다음 후보 중 최솟값을 선택하고 같은 값을 만든 모든 소수 인덱스를 함께 증가시킨다.
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n];
        ugly[0] = 1;

        int[] index = new int[primes.length];
        long[] candidate = new long[primes.length];

        for (int i = 0; i < primes.length; i++) candidate[i] = primes[i];

        for (int position = 1; position < n; position++) {
            long next = Long.MAX_VALUE;

            for (long value : candidate) next = Math.min(next, value);

            ugly[position] = next;

            for (int prime = 0; prime < primes.length; prime++) {
                if (candidate[prime] == next) {
                    index[prime]++;
                    candidate[prime] = ugly[index[prime]] * primes[prime];
                }
            }
        }

        return (int) ugly[n - 1];
    }
}
