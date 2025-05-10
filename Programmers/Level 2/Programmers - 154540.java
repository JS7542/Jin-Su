import java.util.*;

class Solution {
    /*
     * 아직 방문하지 않은 숫자 칸에서 BFS를 시작해 연결된 식량 합을 구한다.
     * 섬별 식량 합을 오름차순으로 정렬하고 섬이 없으면 -1을 반환한다.
     */
    public int[] solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> islands = new ArrayList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] || maps[row].charAt(col) == 'X') continue;

                int sum = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                visited[row][col] = true;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    sum += maps[current[0]].charAt(current[1]) - '0';

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (visited[nr][nc] || maps[nr].charAt(nc) == 'X') continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                islands.add(sum);
            }
        }

        if (islands.isEmpty()) return new int[]{-1};

        Collections.sort(islands);
        return islands.stream().mapToInt(Integer::intValue).toArray();
    }
}
