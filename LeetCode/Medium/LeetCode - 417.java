import java.util.*;

class Solution {
    /*
     * 태평양과 대서양 경계에서 각각 역방향 BFS를 수행한다.
     * 현재 높이 이상인 칸으로 이동해 각 바다에 도달 가능한 칸을 표시하고 교집합을 반환한다.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            add(pacificQueue, pacific, row, 0);
            add(atlanticQueue, atlantic, row, cols - 1);
        }

        for (int col = 0; col < cols; col++) {
            add(pacificQueue, pacific, 0, col);
            add(atlanticQueue, atlantic, rows - 1, col);
        }

        flow(heights, pacificQueue, pacific);
        flow(heights, atlanticQueue, atlantic);

        List<List<Integer>> answer = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    answer.add(Arrays.asList(row, col));
                }
            }
        }

        return answer;
    }

    private void add(
            Queue<int[]> queue,
            boolean[][] visited,
            int row,
            int col
    ) {
        if (visited[row][col]) return;

        visited[row][col] = true;
        queue.offer(new int[]{row, col});
    }

    private void flow(
            int[][] heights,
            Queue<int[]> queue,
            boolean[][] visited
    ) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < heights[current[0]][current[1]]) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
