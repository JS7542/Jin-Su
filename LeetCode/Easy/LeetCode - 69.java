class Solution {
    /*
     * 0부터 x까지 이분 탐색하며 제곱이 x 이하인 가장 큰 정수를 찾는다.
     * 곱셈 오버플로를 막기 위해 mid를 long으로 계산한다.
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square <= x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
