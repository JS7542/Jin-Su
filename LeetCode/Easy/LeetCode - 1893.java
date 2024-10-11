class Solution {
    /*
     * 각 구간에 포함되는 정수를 boolean 배열에 표시한다.
     * left부터 right까지 모든 값이 표시되었는지 확인한다.
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[51];

        for (int[] range : ranges) {
            for (int value = range[0]; value <= range[1]; value++) covered[value] = true;
        }

        for (int value = left; value <= right; value++) {
            if (!covered[value]) return false;
        }

        return true;
    }
}
