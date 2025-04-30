class Solution {
    /*
     * 각 위치의 약수 중 자신을 제외한 가장 큰 값이 블록 번호가 된다.
     * 10,000,000 이하인 가장 큰 몫을 우선 찾고, 없으면 작은 약수를 사용한다.
     */
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (long number = begin; number <= end; number++) {
            answer[(int) (number - begin)] = block(number);
        }

        return answer;
    }

    private int block(long number) {
        if (number == 1) return 0;

        int fallback = 1;

        for (long divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor != 0) continue;

            long quotient = number / divisor;

            if (quotient <= 10_000_000) return (int) quotient;
            if (divisor <= 10_000_000) fallback = (int) divisor;
        }

        return fallback;
    }
}
