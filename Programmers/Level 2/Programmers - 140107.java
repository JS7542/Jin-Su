class Solution {
    /*
     * x를 K의 배수로 순회하며 원 내부에 들어가는 최대 y를 제곱식으로 구한다.
     * 가능한 y의 K 배수 개수에 원점 포함 1을 더해 누적한다.
     */
    public long solution(int k, int d) {
        long answer = 0;
        long radiusSquared = (long) d * d;

        for (long x = 0; x <= d; x += k) {
            long maximumY = (long) Math.sqrt(radiusSquared - x * x);

            while ((maximumY + 1) * (maximumY + 1) <= radiusSquared - x * x) {
                maximumY++;
            }
            while (maximumY * maximumY > radiusSquared - x * x) {
                maximumY--;
            }

            answer += maximumY / k + 1;
        }

        return answer;
    }
}
