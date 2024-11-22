class Solution {
    /*
     * 1부터 num까지 이분 탐색하며 중간값의 제곱을 num과 비교한다.
     * 제곱이 정확히 같으면 완전제곱수이며 탐색이 끝나면 false를 반환한다.
     */
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) return true;
            if (square < num) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
