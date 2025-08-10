import java.io.*;
import java.util.*;

class Solution {
    /*
     * 방문하지 않은 0이 아닌 칸을 직사각형의 왼쪽 위로 본다.
     * 연속한 행과 열 크기를 구해 기록하고 넓이, 행 크기 순으로 정렬한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            List<int[]> rectangles = new ArrayList<>();

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (matrix[row][col] == 0) continue;

                    int height = 0;
                    int width = 0;

                    while (row + height < n && matrix[row + height][col] != 0) height++;
                    while (col + width < n && matrix[row][col + width] != 0) width++;

                    rectangles.add(new int[]{height, width});

                    for (int r = row; r < row + height; r++) {
                        for (int c = col; c < col + width; c++) {
                            matrix[r][c] = 0;
                        }
                    }
                }
            }

            rectangles.sort((first, second) -> {
                int firstArea = first[0] * first[1];
                int secondArea = second[0] * second[1];

                int compare = Integer.compare(firstArea, secondArea);
                return compare != 0
                        ? compare
                        : Integer.compare(first[0], second[0]);
            });

            output.append('#').append(tc).append(' ')
                    .append(rectangles.size()).append(' ');

            for (int[] rectangle : rectangles) {
                output.append(rectangle[0]).append(' ')
                        .append(rectangle[1]).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
