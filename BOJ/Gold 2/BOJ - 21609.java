import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int colors;
    static int[][] board;
    static final int EMPTY = -2;
    static final int BLACK = -1;

    /*
     * 기준 블록 조건에 맞는 가장 큰 블록 그룹을 BFS로 찾는다.
     * 그룹 제거, 중력, 반시계 회전, 중력을 반복하며 점수를 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        colors = Integer.parseInt(st.nextToken());
        board = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;

        while (true) {
            Group group = findBestGroup();

            if (group == null || group.cells.size() < 2) break;

            for (int[] cell : group.cells) {
                board[cell[0]][cell[1]] = EMPTY;
            }

            int groupSize = group.cells.size();
            score += groupSize * groupSize;

            gravity();
            rotateCounterClockwise();
            gravity();
        }

        System.out.print(score);
    }

    static Group findBestGroup() {
        boolean[][] visitedNormal = new boolean[size][size];
        Group best = null;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] <= 0 || visitedNormal[row][col]) continue;

                Group current = buildGroup(row, col, visitedNormal);

                if (current.cells.size() < 2) continue;

                if (best == null || current.betterThan(best)) best = current;
            }
        }

        return best;
    }

    static Group buildGroup(
            int startRow,
            int startCol,
            boolean[][] visitedNormal
    ) {
        int color = board[startRow][startCol];
        boolean[][] visited = new boolean[size][size];
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> cells = new ArrayList<>();

        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        visitedNormal[startRow][startCol] = true;

        int rainbow = 0;
        int baseRow = startRow;
        int baseCol = startCol;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            cells.add(current);

            if (board[current[0]][current[1]] == 0) {
                rainbow++;
            } else {
                if (current[0] < baseRow
                        || (current[0] == baseRow && current[1] < baseCol)) {
                    baseRow = current[0];
                    baseCol = current[1];
                }
            }

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != 0 && board[nr][nc] != color) continue;

                visited[nr][nc] = true;

                if (board[nr][nc] == color) visitedNormal[nr][nc] = true;

                queue.offer(new int[]{nr, nc});
            }
        }

        return new Group(cells, rainbow, baseRow, baseCol);
    }

    static void gravity() {
        for (int col = 0; col < size; col++) {
            for (int row = size - 2; row >= 0; row--) {
                if (board[row][col] == BLACK || board[row][col] == EMPTY) continue;

                int destination = row;

                while (destination + 1 < size
                        && board[destination + 1][col] == EMPTY) {
                    destination++;
                }

                if (destination != row) {
                    board[destination][col] = board[row][col];
                    board[row][col] = EMPTY;
                }
            }
        }
    }

    static void rotateCounterClockwise() {
        int[][] rotated = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                rotated[size - 1 - col][row] = board[row][col];
            }
        }

        board = rotated;
    }

    static class Group {
        List<int[]> cells;
        int rainbow;
        int baseRow;
        int baseCol;

        Group(
                List<int[]> cells,
                int rainbow,
                int baseRow,
                int baseCol
        ) {
            this.cells = cells;
            this.rainbow = rainbow;
            this.baseRow = baseRow;
            this.baseCol = baseCol;
        }

        boolean betterThan(Group other) {
            if (cells.size() != other.cells.size()) {
                return cells.size() > other.cells.size();
            }

            if (rainbow != other.rainbow) return rainbow > other.rainbow;
            if (baseRow != other.baseRow) return baseRow > other.baseRow;

            return baseCol > other.baseCol;
        }
    }
}
