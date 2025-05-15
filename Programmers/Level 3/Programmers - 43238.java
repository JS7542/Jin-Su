class Solution {
    /*
     * 주어진 시간 동안 각 심사관이 처리할 수 있는 사람 수를 합산한다.
     * 모든 사람이 심사를 마칠 수 있는 최소 시간을 이분 탐색한다.
     */
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 0;

        for (int time : times) right = Math.max(right, time);

        right *= n;

        while (left < right) {
            long middle = left + (right - left) / 2;
            long processed = 0;

            for (int time : times) {
                processed += middle / time;

                if (processed >= n) break;
            }

            if (processed >= n) right = middle;
            else left = middle + 1;
        }

        return left;
    }
}
