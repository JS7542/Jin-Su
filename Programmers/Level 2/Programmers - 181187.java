class Solution {
    /*
     * 양의 x좌표마다 큰 원 안의 최대 y와 작은 원 밖의 최소 y를 계산한다.
     * 첫 사분면과 축의 개수를 대칭 확장해 전체 정수 좌표 쌍 수를 구한다.
     */
    public long solution(int r1, int r2) {
        long answer = 0;
        long innerSquared = (long) r1 * r1;
        long outerSquared = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {
            long maximumY = floorSqrt(outerSquared - x * x);
            long minimumY = x >= r1
                    ? 0
                    : ceilSqrt(innerSquared - x * x);

            answer += (maximumY - minimumY + 1) * 4;
        }

        return answer;
    }

    private long floorSqrt(long value) {
        long result = (long) Math.sqrt(value);

        while ((result + 1) * (result + 1) <= value) result++;
        while (result * result > value) result--;

        return result;
    }

    private long ceilSqrt(long value) {
        long result = floorSqrt(value);

        return result * result == value ? result : result + 1;
    }
}
