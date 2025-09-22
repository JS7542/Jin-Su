class Solution {
    /*
     * 아래, 오른쪽, 왼쪽 위 세 방향을 차례로 반복하며 삼각형 칸을 채운다.
     * 각 단계의 이동 횟수를 하나씩 줄이고 행 순서대로 결과 배열에 옮긴다.
     */
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};

        int row = -1;
        int col = 0;
        int value = 1;
        int length = n;
        int direction = 0;

        while (length > 0) {
            for (int step = 0; step < length; step++) {
                row += dr[direction];
                col += dc[direction];
                triangle[row][col] = value++;
            }

            direction = (direction + 1) % 3;
            length--;
        }

        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;

        for (int currentRow = 0; currentRow < n; currentRow++) {
            for (int currentCol = 0; currentCol <= currentRow; currentCol++) {
                answer[index++] = triangle[currentRow][currentCol];
            }
        }

        return answer;
    }
}
