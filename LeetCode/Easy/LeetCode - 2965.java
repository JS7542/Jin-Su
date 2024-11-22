class Solution {
    /*
     * 1부터 n²까지의 숫자별 등장 횟수를 센다.
     * 두 번 등장한 값과 한 번도 등장하지 않은 값을 찾아 반환한다.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];

        for (int[] row : grid) {
            for (int value : row) count[value]++;
        }

        int repeated = 0;
        int missing = 0;

        for (int value = 1; value < count.length; value++) {
            if (count[value] == 2) repeated = value;
            else if (count[value] == 0) missing = value;
        }

        return new int[]{repeated, missing};
    }
}
