class Solution {
    /*
     * 첫 두 점으로 기준 방향 벡터를 만든다.
     * 이후 모든 점과 첫 점의 벡터가 같은 기울기인지 외적으로 비교한다.
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int currentX = coordinates[i][0] - coordinates[0][0];
            int currentY = coordinates[i][1] - coordinates[0][1];

            if ((long) dx * currentY != (long) dy * currentX) return false;
        }

        return true;
    }
}
