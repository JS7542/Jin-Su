class Solution {
    /*
     * 시간 T까지 처리 시작된 작업 수를 계산해 N번째 작업이 시작되는 최소 시간을 이분 탐색한다.
     * 바로 전 시간까지의 작업 수를 구한 뒤 T에 비는 코어를 순서대로 확인한다.
     */
    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;

        long left = 0;
        long right = (long) cores[0] * n;

        while (left < right) {
            long middle = (left + right) / 2;
            long processed = cores.length;

            for (int core : cores) processed += middle / core;

            if (processed >= n) right = middle;
            else left = middle + 1;
        }

        long time = left;
        long processedBefore = cores.length;

        if (time > 0) {
            for (int core : cores) processedBefore += (time - 1) / core;
        }

        for (int index = 0; index < cores.length; index++) {
            if (time % cores[index] == 0) {
                processedBefore++;

                if (processedBefore == n) return index + 1;
            }
        }

        return -1;
    }
}
