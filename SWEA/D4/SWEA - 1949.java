import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static int maximumCut;
    static int[][] mountain;
    static boolean[][] visited;
    static int answer;
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    /*
     * 가장 높은 봉우리마다 DFS를 시작해 낮은 칸으로만 이동한다.
     * 한 번에 한해 이웃을 최대 K만큼 깎아 현재 높이보다 낮게 만들 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            maximumCut = Integer.parseInt(st.nextToken());

            mountain = new int[size][size];
            int highest = 0;

            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    mountain[row][col] = Integer.parseInt(st.nextToken());
                    highest = Math.max(highest, mountain[row][col]);
                }
            }

            answer = 0;
            visited = new boolean[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (mountain[row][col] != highest) continue;

                    visited[row][col] = true;
                    search(row, col, highest, false, 1);
                    visited[row][col] = false;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(
            int row,
            int col,
            int currentHeight,
            boolean cutUsed,
            int length
    ) {
        answer = Math.max(answer, length);

        for (int direction = 0; direction < 4; direction++) {
            int nr = row + DR[direction];
            int nc = col + DC[direction];

            if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
            if (visited[nr][nc]) continue;

            if (mountain[nr][nc] < currentHeight) {
                visited[nr][nc] = true;
                search(
                        nr,
                        nc,
                        mountain[nr][nc],
                        cutUsed,
                        length + 1
                );
                visited[nr][nc] = false;
            } else if (!cutUsed
                    && mountain[nr][nc] - maximumCut < currentHeight) {
                visited[nr][nc] = true;
                search(
                        nr,
                        nc,
                        currentHeight - 1,
                        true,
                        length + 1
                );
                visited[nr][nc] = false;
            }
        }
    }
}
