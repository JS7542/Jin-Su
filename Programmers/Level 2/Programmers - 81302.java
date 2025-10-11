import java.util.*;

class Solution {
    /*
     * 각 응시자 위치에서 맨해튼 거리 2 이하로 BFS를 수행한다.
     * 파티션은 통과하지 않고 다른 응시자를 발견하면 거리두기 위반으로 처리한다.
     */
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int room = 0; room < places.length; room++) {
            answer[room] = valid(places[room]) ? 1 : 0;
        }

        return answer;
    }

    private boolean valid(String[] place) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (place[row].charAt(col) == 'P'
                        && !safeFrom(row, col, place)) return false;
            }
        }

        return true;
    }

    private boolean safeFrom(int startRow, int startCol, String[] place) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[2] == 2) continue;

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5
                        || visited[nr][nc]
                        || place[nr].charAt(nc) == 'X') continue;

                if (place[nr].charAt(nc) == 'P') return false;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, current[2] + 1});
            }
        }

        return true;
    }
}
