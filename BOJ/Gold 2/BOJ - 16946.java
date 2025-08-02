import java.io.*;
import java.util.*;

class Main {
    /*
     * 빈 칸 연결 요소를 BFS로 번호 매기고 각 요소 크기를 저장한다.
     * 벽마다 인접한 서로 다른 요소 크기를 한 번씩 더해 이동 가능한 칸 수를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][];
        for (int row = 0; row < rows; row++) map[row] = br.readLine().toCharArray();

        int[][] group = new int[rows][cols];
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int groupNumber = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col] == '1' || group[row][col] != 0) continue;

                groupNumber++;
                int size = 0;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                group[row][col] = groupNumber;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    size++;

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (map[nr][nc] == '1' || group[nr][nc] != 0) continue;

                        group[nr][nc] = groupNumber;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                sizes.add(size);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col] == '0') {
                    output.append('0');
                    continue;
                }

                int value = 1;
                Set<Integer> adjacentGroups = new HashSet<>();

                for (int d = 0; d < 4; d++) {
                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    int number = group[nr][nc];

                    if (number != 0 && adjacentGroups.add(number)) {
                        value += sizes.get(number);
                    }
                }

                output.append(value % 10);
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
