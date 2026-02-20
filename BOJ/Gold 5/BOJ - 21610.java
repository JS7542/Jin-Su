import java.io.*;
import java.util.*;

class Main {
    /*
     * 구름을 이동시켜 비를 내리고 대각선 물복사 버그를 적용한다.
     * 이전 구름 칸을 제외한 물 2 이상인 칸에 새 구름을 만들며 물을 2 줄인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int commands = Integer.parseInt(st.nextToken());

        int[][] water = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                water[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{size - 1, 0});
        clouds.add(new int[]{size - 1, 1});
        clouds.add(new int[]{size - 2, 0});
        clouds.add(new int[]{size - 2, 1});

        int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

        while (commands-- > 0) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken()) % size;

            boolean[][] wasCloud = new boolean[size][size];
            List<int[]> moved = new ArrayList<>();

            for (int[] cloud : clouds) {
                int row = (cloud[0] + dr[direction] * distance) % size;
                int col = (cloud[1] + dc[direction] * distance) % size;

                if (row < 0) row += size;
                if (col < 0) col += size;

                water[row][col]++;
                wasCloud[row][col] = true;
                moved.add(new int[]{row, col});
            }

            int[] diagonalR = {-1, -1, 1, 1};
            int[] diagonalC = {-1, 1, -1, 1};

            for (int[] cloud : moved) {
                int count = 0;

                for (int diagonal = 0; diagonal < 4; diagonal++) {
                    int nr = cloud[0] + diagonalR[diagonal];
                    int nc = cloud[1] + diagonalC[diagonal];

                    if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                    if (water[nr][nc] > 0) count++;
                }

                water[cloud[0]][cloud[1]] += count;
            }

            clouds = new ArrayList<>();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (!wasCloud[row][col] && water[row][col] >= 2) {
                        water[row][col] -= 2;
                        clouds.add(new int[]{row, col});
                    }
                }
            }
        }

        int answer = 0;

        for (int[] row : water) {
            for (int value : row) answer += value;
        }

        System.out.print(answer);
    }
}
