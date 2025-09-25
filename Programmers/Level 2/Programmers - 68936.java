class Solution {
    /*
     * 현재 정사각형 영역의 모든 값이 같은지 확인한다.
     * 같으면 해당 값 개수를 늘리고, 다르면 네 부분으로 나누어 재귀 처리한다.
     */
    private final int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];
        boolean same = true;

        for (int r = row; r < row + size && same; r++) {
            for (int c = col; c < col + size; c++) {
                if (arr[r][c] != value) {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            answer[value]++;
            return;
        }

        int half = size / 2;
        compress(arr, row, col, half);
        compress(arr, row, col + half, half);
        compress(arr, row + half, col, half);
        compress(arr, row + half, col + half, half);
    }
}
