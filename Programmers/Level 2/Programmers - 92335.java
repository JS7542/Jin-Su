class Solution {
    /*
     * n을 k진수 문자열로 변환하고 0을 기준으로 숫자 조각을 나눈다.
     * 빈 조각을 제외하고 각 값을 소수 판별해 개수를 센다.
     */
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] parts = converted.split("0");

        int answer = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;

            long value = Long.parseLong(part);

            if (isPrime(value)) answer++;
        }

        return answer;
    }

    private boolean isPrime(long value) {
        if (value < 2) return false;

        for (long divisor = 2; divisor * divisor <= value; divisor++) {
            if (value % divisor == 0) return false;
        }

        return true;
    }
}
