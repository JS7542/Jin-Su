class Solution {
    /*
     * 가장 많이 등장한 작업을 기준으로 냉각 구간을 포함한 최소 틀 크기를 계산한다.
     * 동일한 최대 빈도 작업 수를 반영하고 실제 작업 수보다 작으면 작업 수를 반환한다.
     */
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        int maximum = 0;

        for (char task : tasks) {
            frequency[task - 'A']++;
            maximum = Math.max(maximum, frequency[task - 'A']);
        }

        int maximumCount = 0;

        for (int count : frequency) {
            if (count == maximum) maximumCount++;
        }

        int frame = (maximum - 1) * (n + 1) + maximumCount;
        return Math.max(tasks.length, frame);
    }
}
