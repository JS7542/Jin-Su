import java.util.*;

class Solution {
    /*
     * 시작점에서 레버까지, 레버에서 출구까지 각각 BFS 최단 거리를 구한다.
     * 두 구간 중 하나라도 도달할 수 없으면 -1을, 아니면 거리 합을 반환한다.
     */
    public int solution(String[] maps) {
        int[] start = find(maps, 'S');
        int[] lever = find(maps, 'L');
        int[] exit = find(maps, 'E');

        int first = distance(maps, start, lever);

        if (first == -1) return -1;

        int second = distance(maps, lever, exit);

        return second == -1 ? -1 : first + second;
    }

    private int[] find(String[] maps, char target) {
        for (int row = 0; row < maps.length; row++) {
            int col = maps[row].indexOf(target);

            if (col >= 0) return new int[]{row, col};
        }

        return null;
    }

    private int distance(String[] maps, int[] start, int[] target) {
        int rows = maps.length;
        int cols = maps[0].length();
        int[][] distance = new int[rows][cols];

        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == target[0] && current[1] == target[1]) {
                return distance[current[0]][current[1]];
            }

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (maps[nr].charAt(nc) == 'X' || distance[nr][nc] != -1) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return -1;
    }
}
