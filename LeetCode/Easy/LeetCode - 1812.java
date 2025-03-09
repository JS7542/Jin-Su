class Solution {
    /*
     * 체스판 색은 열 번호와 행 번호의 합 홀짝에 따라 결정된다.
     * 두 좌표 값의 합이 홀수이면 흰색 칸이다.
     */
    public boolean squareIsWhite(String coordinates) {
        int column = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '0';
        return (column + row) % 2 == 1;
    }
}
