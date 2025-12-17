import java.util.*;

class Solution {
    /*
     * 좌표 범위 안에서 이동 가능한 명령만 처리한다.
     * 같은 길을 양방향 문자열로 정규화해 집합에 저장하고 처음 지나간 길 수를 센다.
     */
    public int solution(String dirs) {
        int row = 0;
        int col = 0;
        Set<String> roads = new HashSet<>();

        for (char command : dirs.toCharArray()) {
            int nextRow = row;
            int nextCol = col;

            if (command == 'U') nextRow++;
            else if (command == 'D') nextRow--;
            else if (command == 'R') nextCol++;
            else nextCol--;

            if (nextRow < -5 || nextRow > 5
                    || nextCol < -5 || nextCol > 5) continue;

            String forward = row + "," + col + ">" + nextRow + "," + nextCol;
            String backward = nextRow + "," + nextCol + ">" + row + "," + col;

            roads.add(forward.compareTo(backward) < 0 ? forward : backward);
            row = nextRow;
            col = nextCol;
        }

        return roads.size();
    }
}
