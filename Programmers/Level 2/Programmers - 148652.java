class Solution {
    /*
     * 길이 5^n 구간은 가운데 1/5이 모두 0이고 나머지 네 구간은 이전 단계 구조다.
     * 구간별 1의 개수를 재귀적으로 계산해 [l,r] 범위의 1 개수를 구한다.
     */
    public int solution(int n, long l, long r) {
        return (int) (count(n, r) - count(n, l - 1));
    }

    private long count(int level, long position) {
        if (position <= 0 || level == 0) return position <= 0 ? 0 : 1;

        long blockLength = power(5, level - 1);
        long onesPerBlock = power(4, level - 1);
        long fullBlocks = position / blockLength;
        long remainder = position % blockLength;
        long result = 0;

        if (fullBlocks <= 2) {
            result = fullBlocks * onesPerBlock;
        } else {
            result = (fullBlocks - 1) * onesPerBlock;
        }

        if (fullBlocks == 2) return result;

        if (remainder > 0 && fullBlocks < 5) {
            result += count(level - 1, remainder);
        }

        return result;
    }

    private long power(long base, int exponent) {
        long result = 1;

        while (exponent-- > 0) result *= base;

        return result;
    }
}
