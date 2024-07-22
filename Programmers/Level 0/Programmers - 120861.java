class Solution {
    /*
     * 입력 명령에 따라 좌표를 한 칸 이동시키되 보드 경계를 넘지 않도록 제한한다.
     * 모든 명령을 처리한 최종 x, y 좌표를 반환한다.
     */
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String command : keyinput) {
            if (command.equals("left") && x > -maxX) x--;
            else if (command.equals("right") && x < maxX) x++;
            else if (command.equals("up") && y < maxY) y++;
            else if (command.equals("down") && y > -maxY) y--;
        }

        return new int[]{x, y};
    }
}
