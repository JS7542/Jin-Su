import java.util.*;

class Solution {
    /*
     * 게임판의 빈칸과 테이블의 퍼즐 조각을 BFS로 분리해 상대 좌표 형태로 정규화한다.
     * 각 빈칸에 대해 조각을 최대 네 번 회전하며 같은 형태를 찾으면 사용 처리한다.
     */
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> blanks = extract(game_board, 0);
        List<List<int[]>> pieces = extract(table, 1);
        boolean[] used = new boolean[pieces.size()];
        int answer = 0;

        for (List<int[]> blank : blanks) {
            String target = encode(normalize(blank));

            for (int index = 0; index < pieces.size(); index++) {
                if (used[index] || pieces.get(index).size() != blank.size()) continue;

                List<int[]> rotated = normalize(pieces.get(index));

                for (int rotation = 0; rotation < 4; rotation++) {
                    if (encode(normalize(rotated)).equals(target)) {
                        used[index] = true;
                        answer += blank.size();
                        rotation = 4;
                        index = pieces.size();
                        break;
                    }

                    rotated = rotate(rotated);
                }
            }
        }

        return answer;
    }

    private List<List<int[]>> extract(int[][] board, int target) {
        int size = board.length;
        boolean[][] visited = new boolean[size][size];
        List<List<int[]>> shapes = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (visited[row][col] || board[row][col] != target) continue;

                List<int[]> shape = new ArrayList<>();
                Queue<int[]> queue = new ArrayDeque<>();

                queue.offer(new int[]{row, col});
                visited[row][col] = true;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    shape.add(new int[]{current[0], current[1]});

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = current[0] + dr[direction];
                        int nc = current[1] + dc[direction];

                        if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                        if (visited[nr][nc] || board[nr][nc] != target) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                shapes.add(normalize(shape));
            }
        }

        return shapes;
    }

    private List<int[]> normalize(List<int[]> shape) {
        int minimumRow = Integer.MAX_VALUE;
        int minimumCol = Integer.MAX_VALUE;

        for (int[] cell : shape) {
            minimumRow = Math.min(minimumRow, cell[0]);
            minimumCol = Math.min(minimumCol, cell[1]);
        }

        List<int[]> normalized = new ArrayList<>();

        for (int[] cell : shape) {
            normalized.add(new int[]{
                cell[0] - minimumRow,
                cell[1] - minimumCol
            });
        }

        normalized.sort((first, second) -> {
            int compare = Integer.compare(first[0], second[0]);
            return compare != 0
                    ? compare
                    : Integer.compare(first[1], second[1]);
        });

        return normalized;
    }

    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] cell : shape) {
            rotated.add(new int[]{cell[1], -cell[0]});
        }

        return normalize(rotated);
    }

    private String encode(List<int[]> shape) {
        StringBuilder value = new StringBuilder();

        for (int[] cell : shape) {
            value.append(cell[0]).append(',')
                    .append(cell[1]).append(';');
        }

        return value.toString();
    }
}
