import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int[][] forest;
    static int[][] memo;
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    /*
     * 각 칸에서 시작해 더 많은 대나무가 있는 인접 칸으로만 DFS한다.
     * 칸별 최대 생존 일수를 메모이제이션해 전체 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        forest = new int[size][size];
        memo = new int[size][size];

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                forest[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                answer = Math.max(answer, search(row, col));
            }
        }

        System.out.print(answer);
    }

    static int search(int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];

        memo[row][col] = 1;

        for (int direction = 0; direction < 4; direction++) {
            int nr = row + DR[direction];
            int nc = col + DC[direction];

            if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
            if (forest[nr][nc] <= forest[row][col]) continue;

            memo[row][col] = Math.max(
                    memo[row][col],
                    search(nr, nc) + 1
            );
        }

        return memo[row][col];
    }
}
