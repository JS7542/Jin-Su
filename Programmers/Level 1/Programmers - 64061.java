import java.util.*;

class Solution {
    /*
     * 각 크레인 열에서 가장 위의 인형을 찾아 바구니 스택에 넣는다.
     * 스택 위 인형과 같으면 두 인형을 제거하고 터진 인형 수를 2 증가시킨다.
     */
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> basket = new ArrayDeque<>();
        int removed = 0;

        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board.length; row++) {
                int doll = board[row][col];

                if (doll == 0) continue;

                board[row][col] = 0;

                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    removed += 2;
                } else {
                    basket.push(doll);
                }

                break;
            }
        }

        return removed;
    }
}
