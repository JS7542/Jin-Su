class Solution {
    /*
     * 자물쇠를 3배 크기 판 중앙에 두고 열쇠를 네 방향으로 회전한다.
     * 모든 이동 위치에서 열쇠를 더한 뒤 중앙 자물쇠 영역이 모두 1인지 확인한다.
     */
    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int boardSize = lockSize * 3;
        int[][] board = new int[boardSize][boardSize];

        for (int row = 0; row < lockSize; row++) {
            for (int col = 0; col < lockSize; col++) {
                board[row + lockSize][col + lockSize] = lock[row][col];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);

            for (int row = 0; row <= boardSize - key.length; row++) {
                for (int col = 0; col <= boardSize - key.length; col++) {
                    apply(board, key, row, col, 1);

                    if (unlocked(board, lockSize)) return true;

                    apply(board, key, row, col, -1);
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] key) {
        int size = key.length;
        int[][] rotated = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                rotated[col][size - 1 - row] = key[row][col];
            }
        }

        return rotated;
    }

    private void apply(
            int[][] board,
            int[][] key,
            int startRow,
            int startCol,
            int sign
    ) {
        for (int row = 0; row < key.length; row++) {
            for (int col = 0; col < key.length; col++) {
                board[startRow + row][startCol + col] += key[row][col] * sign;
            }
        }
    }

    private boolean unlocked(int[][] board, int lockSize) {
        for (int row = lockSize; row < lockSize * 2; row++) {
            for (int col = lockSize; col < lockSize * 2; col++) {
                if (board[row][col] != 1) return false;
            }
        }

        return true;
    }
}
