class Solution {
    /*
     * 각 행의 1 개수를 센다.
     * 더 많은 1을 가진 첫 번째 행의 인덱스와 개수를 반환한다.
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowIndex = 0;
        int maxCount = -1;

        for (int r = 0; r < mat.length; r++) {
            int count = 0;
            for (int value : mat[r]) count += value;

            if (count > maxCount) {
                maxCount = count;
                rowIndex = r;
            }
        }

        return new int[]{rowIndex, maxCount};
    }
}
