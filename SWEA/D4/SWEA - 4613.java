import java.io.*;
import java.util.*;

class Solution {
    /*
     * 흰색 영역 끝 행과 파란색 영역 끝 행을 모두 시도한다.
     * 각 행을 W·B·R로 바꾸는 비용을 누적해 최소 재도색 칸 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());

            int[][] repaint = new int[rows][3];

            for (int row = 0; row < rows; row++) {
                String line = br.readLine();

                for (int col = 0; col < cols; col++) {
                    char color = line.charAt(col);

                    if (color != 'W') repaint[row][0]++;
                    if (color != 'B') repaint[row][1]++;
                    if (color != 'R') repaint[row][2]++;
                }
            }

            int answer = Integer.MAX_VALUE;

            for (int whiteEnd = 0; whiteEnd < rows - 2; whiteEnd++) {
                for (int blueEnd = whiteEnd + 1; blueEnd < rows - 1; blueEnd++) {
                    int cost = 0;

                    for (int row = 0; row <= whiteEnd; row++) {
                        cost += repaint[row][0];
                    }

                    for (int row = whiteEnd + 1; row <= blueEnd; row++) {
                        cost += repaint[row][1];
                    }

                    for (int row = blueEnd + 1; row < rows; row++) {
                        cost += repaint[row][2];
                    }

                    answer = Math.min(answer, cost);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
