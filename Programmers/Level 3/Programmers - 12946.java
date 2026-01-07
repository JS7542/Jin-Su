import java.util.*;

class Solution {
    /*
     * n-1개 원판을 보조 기둥으로 옮기고 가장 큰 원판을 목표 기둥으로 이동한다.
     * 다시 n-1개 원판을 목표 기둥으로 옮기는 재귀 과정을 기록한다.
     */
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        move(n, 1, 2, 3, moves);
        return moves.toArray(new int[0][]);
    }

    private void move(
            int count,
            int from,
            int via,
            int to,
            List<int[]> moves
    ) {
        if (count == 0) return;

        move(count - 1, from, to, via, moves);
        moves.add(new int[]{from, to});
        move(count - 1, via, from, to, moves);
    }
}
