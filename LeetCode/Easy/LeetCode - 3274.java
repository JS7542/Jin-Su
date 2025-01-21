class Solution {
    /*
     * 체스판 칸의 색은 열과 행 좌표 합의 홀짝으로 결정된다.
     * 두 좌표의 홀짝 값이 같은지 비교한다.
     */
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return color(coordinate1) == color(coordinate2);
    }

    private int color(String coordinate) {
        return (coordinate.charAt(0) - 'a' + coordinate.charAt(1) - '1') % 2;
    }
}
