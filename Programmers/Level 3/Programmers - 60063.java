import java.util.*;

class Solution {
    /*
     * 로봇의 두 칸 위치를 정렬한 상태로 BFS한다.
     * 평행 이동과 회전으로 만들 수 있는 다음 상태를 생성하고 처음 도착한 거리를 반환한다.
     */
    public int solution(int[][] board) {
        int size = board.length;
        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        State start = new State(0, 0, 0, 1, 0);
        queue.offer(start);
        visited.add(start.key());

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if ((current.r1 == size - 1 && current.c1 == size - 1)
                    || (current.r2 == size - 1 && current.c2 == size - 1)) {
                return current.distance;
            }

            for (State next : nextStates(current, board)) {
                if (visited.add(next.key())) queue.offer(next);
            }
        }

        return -1;
    }

    private List<State> nextStates(State state, int[][] board) {
        List<State> result = new ArrayList<>();
        int size = board.length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr1 = state.r1 + dr[d];
            int nc1 = state.c1 + dc[d];
            int nr2 = state.r2 + dr[d];
            int nc2 = state.c2 + dc[d];

            if (free(nr1, nc1, board, size) && free(nr2, nc2, board, size)) {
                result.add(new State(nr1, nc1, nr2, nc2, state.distance + 1));
            }
        }

        if (state.r1 == state.r2) {
            for (int direction : new int[]{-1, 1}) {
                int newRow = state.r1 + direction;

                if (free(newRow, state.c1, board, size)
                        && free(newRow, state.c2, board, size)) {
                    result.add(new State(
                            state.r1, state.c1,
                            newRow, state.c1,
                            state.distance + 1
                    ));
                    result.add(new State(
                            state.r2, state.c2,
                            newRow, state.c2,
                            state.distance + 1
                    ));
                }
            }
        } else {
            for (int direction : new int[]{-1, 1}) {
                int newCol = state.c1 + direction;

                if (free(state.r1, newCol, board, size)
                        && free(state.r2, newCol, board, size)) {
                    result.add(new State(
                            state.r1, state.c1,
                            state.r1, newCol,
                            state.distance + 1
                    ));
                    result.add(new State(
                            state.r2, state.c2,
                            state.r2, newCol,
                            state.distance + 1
                    ));
                }
            }
        }

        return result;
    }

    private boolean free(int row, int col, int[][] board, int size) {
        return row >= 0 && row < size
                && col >= 0 && col < size
                && board[row][col] == 0;
    }

    private static class State {
        int r1;
        int c1;
        int r2;
        int c2;
        int distance;

        State(int r1, int c1, int r2, int c2, int distance) {
            if (r1 > r2 || (r1 == r2 && c1 > c2)) {
                this.r1 = r2;
                this.c1 = c2;
                this.r2 = r1;
                this.c2 = c1;
            } else {
                this.r1 = r1;
                this.c1 = c1;
                this.r2 = r2;
                this.c2 = c2;
            }

            this.distance = distance;
        }

        String key() {
            return r1 + "," + c1 + "," + r2 + "," + c2;
        }
    }
}
