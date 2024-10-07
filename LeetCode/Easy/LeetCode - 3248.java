import java.util.*;

class Solution {
    /*
     * 명령에 따라 행과 열 위치를 갱신한다.
     * 최종 좌표를 일차원 인덱스 row*n+column으로 변환한다.
     */
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int column = 0;

        for (String command : commands) {
            if (command.equals("UP")) row--;
            else if (command.equals("DOWN")) row++;
            else if (command.equals("LEFT")) column--;
            else column++;
        }

        return row * n + column;
    }
}
