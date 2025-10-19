import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 단계마다 2^L 크기 부분 격자를 시계 방향으로 회전한다.
     * 인접 얼음이 세 칸 미만인 칸을 동시에 녹이고 마지막에 총량과 최대 덩어리를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int exponent = Integer.parseInt(st.nextToken());
        int commands = Integer.parseInt(st.nextToken());
        int size = 1 << exponent;

        int[][] ice = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                ice[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while (commands-- > 0) {
            int level = Integer.parseInt(st.nextToken());
            rotate(ice, 1 << level);
            melt(ice);
        }

        int total = 0;

        for (int[] row : ice) {
            for (int value : row) total += value;
        }

        int largest = largestBlock(ice);

        System.out.println(total);
        System.out.print(largest);
    }

    static void rotate(int[][] ice, int blockSize) {
        int size = ice.length;
        int[][] rotated = new int[size][size];

        for (int startRow = 0; startRow < size; startRow += blockSize) {
            for (int startCol = 0; startCol < size; startCol += blockSize) {
                for (int row = 0; row < blockSize; row++) {
                    for (int col = 0; col < blockSize; col++) {
                        rotated[startRow + col][startCol + blockSize - 1 - row]
                                = ice[startRow + row][startCol + col];
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) ice[row] = rotated[row];
    }

    static void melt(int[][] ice) {
        int size = ice.length;
        boolean[][] decrease = new boolean[size][size];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (ice[row][col] == 0) continue;

                int adjacent = 0;

                for (int direction = 0; direction < 4; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr >= 0 && nr < size && nc >= 0 && nc < size
                            && ice[nr][nc] > 0) {
                        adjacent++;
                    }
                }

                if (adjacent < 3) decrease[row][col] = true;
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (decrease[row][col]) ice[row][col]--;
            }
        }
    }

    static int largestBlock(int[][] ice) {
        int size = ice.length;
        boolean[][] visited = new boolean[size][size];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int largest = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (visited[row][col] || ice[row][col] == 0) continue;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                visited[row][col] = true;
                int count = 0;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    count++;

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = current[0] + dr[direction];
                        int nc = current[1] + dc[direction];

                        if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                        if (visited[nr][nc] || ice[nr][nc] == 0) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                largest = Math.max(largest, count);
            }
        }

        return largest;
    }
}
