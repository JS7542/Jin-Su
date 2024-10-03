class Solution {
    /*
     * 첫 행에 빨강 또는 파랑을 사용하는 두 경우를 각각 시뮬레이션한다.
     * 행 번호만큼 필요한 공을 번갈아 사용하며 만들 수 있는 최대 높이를 구한다.
     */
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(height(red, blue), height(blue, red));
    }

    private int height(int firstColor, int secondColor) {
        int row = 1;

        while (true) {
            if (row % 2 == 1) {
                if (firstColor < row) return row - 1;
                firstColor -= row;
            } else {
                if (secondColor < row) return row - 1;
                secondColor -= row;
            }

            row++;
        }
    }
}
