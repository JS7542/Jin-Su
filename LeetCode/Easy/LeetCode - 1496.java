import java.util.*;

class Solution {
    /*
     * 현재 좌표를 문자열 키로 만들어 방문 집합에 저장한다.
     * 명령마다 이동한 좌표가 이미 집합에 있으면 경로가 교차한다.
     */
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add("0,0");

        for (char direction : path.toCharArray()) {
            if (direction == 'N') y++;
            else if (direction == 'S') y--;
            else if (direction == 'E') x++;
            else x--;

            if (!visited.add(x + "," + y)) return true;
        }

        return false;
    }
}
