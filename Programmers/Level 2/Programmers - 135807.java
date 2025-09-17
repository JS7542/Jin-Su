class Solution {
    /*
     * 각 배열 전체의 최대공약수를 구한다.
     * 한 배열의 최대공약수가 상대 배열의 어떤 수도 나누지 못하는지 확인해 가능한 최댓값을 반환한다.
     */
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int value : arrayA) gcdA = gcd(gcdA, value);
        for (int value : arrayB) gcdB = gcd(gcdB, value);

        int answer = 0;

        if (cannotDivide(gcdA, arrayB)) answer = Math.max(answer, gcdA);
        if (cannotDivide(gcdB, arrayA)) answer = Math.max(answer, gcdB);

        return answer;
    }

    private boolean cannotDivide(int divisor, int[] values) {
        for (int value : values) {
            if (value % divisor == 0) return false;
        }

        return true;
    }

    private int gcd(int first, int second) {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }

        return first;
    }
}
