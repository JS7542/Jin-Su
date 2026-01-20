import java.util.*;

class Solution {
    /*
     * 모든 직선 쌍의 교점을 행렬식으로 계산하고 정수 좌표인 교점만 집합에 저장한다.
     * 교점 좌표 범위를 구해 y축을 뒤집은 문자 배열에 별을 표시한다.
     */
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();

        long minimumX = Long.MAX_VALUE;
        long maximumX = Long.MIN_VALUE;
        long minimumY = Long.MAX_VALUE;
        long maximumY = Long.MIN_VALUE;

        for (int first = 0; first < line.length; first++) {
            for (int second = first + 1; second < line.length; second++) {
                long a = line[first][0];
                long b = line[first][1];
                long e = line[first][2];
                long c = line[second][0];
                long d = line[second][1];
                long f = line[second][2];

                long denominator = a * d - b * c;

                if (denominator == 0) continue;

                long xNumerator = b * f - e * d;
                long yNumerator = e * c - a * f;

                if (xNumerator % denominator != 0
                        || yNumerator % denominator != 0) continue;

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                Point point = new Point(x, y);
                points.add(point);

                minimumX = Math.min(minimumX, x);
                maximumX = Math.max(maximumX, x);
                minimumY = Math.min(minimumY, y);
                maximumY = Math.max(maximumY, y);
            }
        }

        int rows = (int) (maximumY - minimumY + 1);
        int cols = (int) (maximumX - minimumX + 1);
        char[][] board = new char[rows][cols];

        for (char[] row : board) Arrays.fill(row, '.');

        for (Point point : points) {
            int row = (int) (maximumY - point.y);
            int col = (int) (point.x - minimumX);
            board[row][col] = '*';
        }

        String[] answer = new String[rows];

        for (int row = 0; row < rows; row++) {
            answer[row] = new String(board[row]);
        }

        return answer;
    }

    private static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Point)) return false;

            Point other = (Point) object;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
