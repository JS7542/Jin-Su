import java.util.*;

class Solution {
    /*
     * 남아 있는 카드 종류를 하나 선택해 두 카드의 방문 순서를 모두 시도한다.
     * 일반 이동과 Ctrl 이동을 포함한 BFS 거리와 Enter 두 번을 더해 최소 조작 수를 재귀 탐색한다.
     */
    private int[][] board;
    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        search(r, c, 0, 0);
        return answer;
    }

    private void search(int row, int col, int removedMask, int moves) {
        if (allRemoved(removedMask)) {
            answer = Math.min(answer, moves);
            return;
        }

        Set<Integer> cardTypes = new HashSet<>();

        for (int[] currentRow : board) {
            for (int card : currentRow) {
                if (card > 0 && (removedMask & (1 << card)) == 0) {
                    cardTypes.add(card);
                }
            }
        }

        for (int card : cardTypes) {
            List<int[]> positions = positions(card);
            int[] first = positions.get(0);
            int[] second = positions.get(1);

            int firstDistance = distance(row, col, first[0], first[1], removedMask);
            int secondDistance = distance(
                    first[0], first[1], second[0], second[1], removedMask
            );

            search(
                    second[0],
                    second[1],
                    removedMask | (1 << card),
                    moves + firstDistance + secondDistance + 2
            );

            int reverseFirst = distance(
                    row, col, second[0], second[1], removedMask
            );
            int reverseSecond = distance(
                    second[0], second[1], first[0], first[1], removedMask
            );

            search(
                    first[0],
                    first[1],
                    removedMask | (1 << card),
                    moves + reverseFirst + reverseSecond + 2
            );
        }
    }

    private boolean allRemoved(int removedMask) {
        for (int[] row : board) {
            for (int card : row) {
                if (card > 0 && (removedMask & (1 << card)) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<int[]> positions(int card) {
        List<int[]> result = new ArrayList<>();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == card) result.add(new int[]{row, col});
            }
        }

        return result;
    }

    private int distance(
            int startRow,
            int startCol,
            int targetRow,
            int targetCol,
            int removedMask
    ) {
        int[][] distance = new int[4][4];

        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == targetRow && current[1] == targetCol) {
                return distance[current[0]][current[1]];
            }

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4
                        && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }

                int[] control = controlMove(
                        current[0],
                        current[1],
                        direction,
                        removedMask
                );

                if (distance[control[0]][control[1]] == -1) {
                    distance[control[0]][control[1]]
                            = distance[current[0]][current[1]] + 1;
                    queue.offer(control);
                }
            }
        }

        return 0;
    }

    private int[] controlMove(
            int row,
            int col,
            int direction,
            int removedMask
    ) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
                return new int[]{row, col};
            }

            row = nr;
            col = nc;

            int card = board[row][col];

            if (card > 0 && (removedMask & (1 << card)) == 0) {
                return new int[]{row, col};
            }
        }
    }
}
