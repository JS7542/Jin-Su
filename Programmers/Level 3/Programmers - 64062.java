class Solution {
    /*
     * 건너는 사람 수를 정하면 그 수보다 작은 디딤돌이 연속 K개인지 확인한다.
     * 건널 수 있는 최대 사람 수를 이분 탐색한다.
     */
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;
        int answer = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (canCross(stones, k, middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int unavailable = 0;

        for (int stone : stones) {
            if (stone < people) unavailable++;
            else unavailable = 0;

            if (unavailable >= k) return false;
        }

        return true;
    }
}
