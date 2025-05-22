class Solution {
    /*
     * 파일이 있는 모든 칸의 최소·최대 행과 열을 찾는다.
     * 드래그 시작점은 최소 좌표, 끝점은 최대 좌표에 1을 더한 값이다.
     */
    public int[] solution(String[] wallpaper) {
        int minimumRow = wallpaper.length;
        int minimumCol = wallpaper[0].length();
        int maximumRow = -1;
        int maximumCol = -1;

        for (int row = 0; row < wallpaper.length; row++) {
            for (int col = 0; col < wallpaper[row].length(); col++) {
                if (wallpaper[row].charAt(col) != '#') continue;

                minimumRow = Math.min(minimumRow, row);
                minimumCol = Math.min(minimumCol, col);
                maximumRow = Math.max(maximumRow, row);
                maximumCol = Math.max(maximumCol, col);
            }
        }

        return new int[]{
            minimumRow,
            minimumCol,
            maximumRow + 1,
            maximumCol + 1
        };
    }
}
